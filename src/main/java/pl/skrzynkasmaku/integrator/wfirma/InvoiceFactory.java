package pl.skrzynkasmaku.integrator.wfirma;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import pl.skrzynkasmaku.integrator.prestashop.model.Address;
import pl.skrzynkasmaku.integrator.prestashop.model.Order;
import pl.skrzynkasmaku.integrator.prestashop.model.OrderDetail;
import pl.skrzynkasmaku.integrator.reference.Reference;
import pl.skrzynkasmaku.integrator.wfirma.model.Contractor;
import pl.skrzynkasmaku.integrator.wfirma.model.IdTaxRulesGroup;
import pl.skrzynkasmaku.integrator.wfirma.model.Invoice;
import pl.skrzynkasmaku.integrator.wfirma.model.Invoicecontent;
import pl.skrzynkasmaku.integrator.wfirma.model.PrestaPayment;
import pl.skrzynkasmaku.integrator.wfirma.model.VatCode;
import pl.skrzynkasmaku.integrator.wfirma.model.Payment;

/**
 *
 * @author Bartosz Spychaj
 */
public abstract class InvoiceFactory {

    private InvoicementFactory invoicementFactory;

    public void setInvoicementFactory(InvoicementFactory invoicementFactory) {
        this.invoicementFactory = invoicementFactory;
    }

    public Invoice build(Order order) {
        Invoice invoice = new Invoice();
        List<Invoicecontent> invoicecontents = new ArrayList<>();
        invoice.setInvoicecontents(invoicecontents);

        Set<OrderDetail> orderDetails = order.getOrderDetails();
        for (OrderDetail orderDetail : orderDetails) {
            Invoicecontent invoicecontent = invoicementFactory.build(orderDetail);
            invoicecontents.add(invoicecontent);
        }
        Invoicecontent shipmentInvoicement = getShipmentInvoicecontent(order);
        if (shipmentInvoicement != null) {
            invoicecontents.add(shipmentInvoicement);
        }
        BigDecimal alreadyPaidInitial = buildAlreadyPaidInitial(order);
        invoice.setAlreadypaidInitial(alreadyPaidInitial);
        Payment wPayment = buildPaimant(order);
        invoice.setPayment(wPayment);
        buildAlreadyPaidInitial(order);
        Address invoiceAddress = order.getInvoiceAddress();
        ContractorFactory contractorFactory = ContractorFactoryProducer.getFactory(invoiceAddress);
        Contractor contractor = contractorFactory.build();
        invoice.setContractor(contractor);

        return invoice;
    }

    private Payment buildPaimant(Order order) {
        PrestaPayment pPayment = order.getPayment();
        Payment wPayment;
        switch (pPayment) {
            case BANKWIRE:
                wPayment = Payment.TRANSFER;
                break;
            case PAYU:
                wPayment = Payment.TRANSFER;
                break;
            case CHEQUE:
                wPayment = Payment.TRANSFER;
                break;
            case FREE_ORDER:
                wPayment = Payment.TRANSFER;
                break;
            case CASHONDELIVERY:
                wPayment = Payment.COD;
                break;
            default:
                wPayment = Payment.TRANSFER;
                break;
        }
        return wPayment;
    }

    private BigDecimal buildAlreadyPaidInitial(Order order) {
        BigDecimal alreadyPaidInitial = null;
        PrestaPayment pPayment = order.getPayment();
        if (pPayment == PrestaPayment.BANKWIRE || pPayment == PrestaPayment.PAYU) {
            alreadyPaidInitial = order.getTotalPaidTaxIncl();
        }
        return alreadyPaidInitial;
    }

    private Invoicecontent getShipmentInvoicecontent(Order order) {
        Invoicecontent invoicecontent = null;
        BigDecimal totalShipping = order.getTotalShipping();
        if (totalShipping != null && totalShipping.compareTo(BigDecimal.ZERO) > 0) {
            invoicecontent = new Invoicecontent();
            invoicecontent.setName("Dostawa");
            invoicecontent.setCount(1);
            invoicecontent.setPrice(totalShipping);
            VatCode vatCode = new VatCode();
            Integer id = IdTaxRulesGroup.TAX_23.getWfirmaValue();
            vatCode.setId(id);
            invoicecontent.setVatCode(vatCode);
        }
        return invoicecontent;
    }

    public static VatCode convert(Integer idTaxRulesGroup) {
        VatCode vatCode = new VatCode();
        IdTaxRulesGroup idTax = IdTaxRulesGroup.getFromPrestaShopValue(idTaxRulesGroup);
        Integer id = idTax.getWfirmaValue();
        vatCode.setId(id);

        return vatCode;
    }

}
