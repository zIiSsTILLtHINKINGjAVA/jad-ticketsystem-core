package be.intecbrussel.jad.services;

import be.intecbrussel.jad.model.data.TicketDAO;
import be.intecbrussel.jad.model.entities.Ticket;


/**
 *
 * @author AliG
 */
public class TicketService extends GenericService<Ticket> {

    TicketDAO ticketDAO;

    public TicketService() {
        super();
        dao = new TicketDAO();
        this.ticketDAO = (TicketDAO) dao;
    }
}
