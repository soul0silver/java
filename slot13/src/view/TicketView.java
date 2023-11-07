package view;

import modal.Ticket;
import modal.TicketDetails;

import java.util.List;

public class TicketView {
    public void showTicket(Ticket ticket, List<TicketDetails> list){
        System.out.println(ticket);
        for (TicketDetails i:list){
            System.out.println(i);
        }
    }
}
