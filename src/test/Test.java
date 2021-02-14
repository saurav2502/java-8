/*
 * Copyright for Test.java by kumar since 8/16/20, 12:42 AM
 */
package test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * The type Test.
 */
public class Test
{

    /**
     * The type Item.
     */
    public static class Item
    {

        private String name;

        private int qty;

        private BigDecimal price;

        /**
         * Instantiates a new Item.
         */
        public Item()
        {
        }

        /**
         * Instantiates a new Item.
         *
         * @param name  the name
         * @param qty   the qty
         * @param price the price
         */
        public Item(String name, int qty, BigDecimal price)
        {
            this.name = name;
            this.qty = qty;
            this.price = price;
        }

        /**
         * Gets name.
         *
         * @return the name
         */
        public String getName()
        {
            return name;
        }

        /**
         * Sets name.
         *
         * @param name the name
         */
        public void setName(String name)
        {
            this.name = name;
        }

        /**
         * Gets qty.
         *
         * @return the qty
         */
        public int getQty()
        {
            return qty;
        }

        /**
         * Sets qty.
         *
         * @param qty the qty
         */
        public void setQty(int qty)
        {
            this.qty = qty;
        }

        /**
         * Gets price.
         *
         * @return the price
         */
        public BigDecimal getPrice()
        {
            return price;
        }

        /**
         * Sets price.
         *
         * @param price the price
         */
        public void setPrice(BigDecimal price)
        {
            this.price = price;
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        List<Item> items = Arrays.asList(new Item("apple", 10, new BigDecimal("9.99")),
            new Item("banana", 20, new BigDecimal("19.99")), new Item("orange", 10, new BigDecimal("29.99")),
            new Item("watermelon", 10, new BigDecimal("29.99")), new Item("papaya", 20, new BigDecimal("9.99")),
            new Item("apple", 10, new BigDecimal("9.99")), new Item("banana", 10, new BigDecimal("19.99")),
            new Item("apple", 20, new BigDecimal("9.99")));

        Map<String, Integer> itemMap = items.stream().collect(groupingBy(Item::getName, summingInt(Item::getQty)));
        System.out.println(itemMap);
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        itemMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey())
            .forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));
        System.out.println(sortedMap);
    }
}
