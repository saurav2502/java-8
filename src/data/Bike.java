/*
 * Copyright for Bike.java by kumar since 8/16/20, 12:42 AM
 */

package data;

/**
 * Created By Saurav Kumar on 7/5/2020
 */
public class Bike {
    private String name;
    private String year;
    private String model;

    /**
     * Instantiates a new Bike.
     *
     * @param name  the name
     * @param model the model
     */
    public Bike(String name, String model) {
        this.name = name;
        this.model = model;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
	   return year;
    }
/**
 *
 **/
    public void setYear(String year){
        this.year = year;
   }


    @Override
    public String toString() {
        return new StringBuilder().append("Bike{").append("name=").append(name).append(", model=")
                .append(model).append('\'').append('}').toString();
    }
}
