package com.example.demo.controller;

import com.example.demo.entity.Ticket;
import com.example.demo.entity.Customer;
import com.example.demo.service.TicketService;
import com.example.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;
    private final CustomerService customerService;

    @GetMapping("/admin")
    public String adminTickets(Model model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "ticket-admin-list";
    }


    @GetMapping("/admin/status/{id}/{newStatus}")
    public String updateStatus(@PathVariable Long id, @PathVariable String newStatus) {
        Ticket ticket = ticketService.getTicketById(id);
        ticket.setStatus(newStatus);
        ticketService.saveTicket(ticket);
        return "redirect:/tickets/admin";
    }

    @GetMapping("/customer/{customerId}")
    public String customerTickets(@PathVariable Long customerId, Model model) {
        Customer customer = customerService.getCustomerById(customerId);
        model.addAttribute("customer", customer);
        model.addAttribute("tickets", ticketService.getTicketsByCustomerId(customerId));
        return "ticket-customer-list";
    }


    @GetMapping("/customer/{customerId}/new")
    public String showTicketForm(@PathVariable Long customerId, Model model) {
        Customer customer = customerService.getCustomerById(customerId);
        Ticket ticket = new Ticket();
        ticket.setCustomer(customer);

        model.addAttribute("customer", customer);
        model.addAttribute("ticket", ticket);
        return "ticket-form";
    }


    @PostMapping("/customer/{customerId}/save")
    public String saveTicket(@PathVariable Long customerId, @ModelAttribute("ticket") Ticket ticket) {
        Customer customer = customerService.getCustomerById(customerId);
        ticket.setCustomer(customer);
        ticketService.saveTicket(ticket);
        return "redirect:/tickets/customer/" + customerId;
    }
}