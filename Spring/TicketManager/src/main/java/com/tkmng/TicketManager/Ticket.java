package com.tkmng.TicketManager;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Ticket {
    private Long id;
    private String eventName;
    private LocalDate eventDate;
    private String buyerName;
    private double price;

    // Costruttore vuoto
    public Ticket() {
    }

    // Costruttore con parametri
    public Ticket(Long id, String eventName, LocalDate eventDate, String buyerName, double price) {
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.buyerName = buyerName;
        this.price = price;
    }

    // Getter e Setter per id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter e Setter per eventName
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    // Getter e Setter per eventDate
    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    // Getter e Setter per buyerName
    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    // Getter e Setter per price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Metodo toString per rappresentazione testuale
    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", eventDate=" + eventDate +
                ", buyerName='" + buyerName + '\'' +
                ", price=" + price +
                '}';
    }

    // Metodo per convertire l'oggetto Ticket in una mappa (HashMap)
    public Map<String, Object> toHashMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("eventName", eventName);
        map.put("eventDate", eventDate);
        map.put("buyerName", buyerName);
        map.put("price", price);
        return map;
    }
}
