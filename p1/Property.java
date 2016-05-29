package propertyshop;
/**
 * Práctica 1 Clases
 * @author chao
 */
public class Property {

    String name;
    String address;
    double constructedSurface;
    double availableSurface;
    String owner;
    String ownerAddress;
    int price;
    
    public Property(){
        name = "Unknow";
        address = "";
        constructedSurface = 0;
        availableSurface = 0;
        owner = "";
        ownerAddress = "";
        price = 0;
    }
    /**
     * This method changes the name of the property.
     * @param name
     */
    public void setName(String name){
        if (name != null){
            this.name = name.toLowerCase();
        }
    }
    /**
     * This method return the name of the property.
     * @return name
     */
    public String getName(){
        return name;
    }
    /**
     * This method changes the address of the property.
     * @param address 
     */
    public void setAddress(String address){
        if (address != null){
            this.address = address.toUpperCase();
        }
    }
    /**
     * This method returns the address of the property.
     * @return address
     */
    public String getAddress(){
        return address;
    }
    /**
     * This method changes the constructed surface of the property.
     * @param constructedSurface 
     */
    public void setConstructedSurface(double constructedSurface){
        if (constructedSurface > 0){
            this.constructedSurface = constructedSurface;
        }
    }
    /**
     * This method returns the constructed surface of the property.
     * @return constructedSurface
     */
    public double getConstructedSurface(){
        return constructedSurface;
    }
    /**
     * This method changes the available surface of the property.
     * @param availableSurface 
     */
    public void setAvailableSurface(double availableSurface){
        if (availableSurface > 0){
            this.availableSurface = availableSurface;
        }
    }
    /**
     * This method returns the available surface of the property.
     * @return availableSurface
     */
    public double getAvailableSurface(){
        return availableSurface;
    }
    /**
     * This method changes the owner name.
     * @param owner 
     */
    public void setOwner(String owner){
        if (owner != null){
            this.owner = owner;
        }
    }
    /**
     * This method returns the owner name.
     * @return owner
     */
    public String getOwner(){
        return owner;
    }
    /**
     * This method changes the owner address.
     * @param ownerAddress 
     */
    public void setOwnerAddress(String ownerAddress){
        if (ownerAddress != null){
            this.ownerAddress = ownerAddress;
        }
    }
    /**
     * This method returns the owner address.
     * @return ownerAddress
     */
    public String getOwnerAddress(){
        return ownerAddress;
    }
    /**
     * This method changes the price of the property.
     * @param price 
     */
    public void setPrice(int price){
        if (price >= 0){
            this.price = price;
        }
    }
    /**
     * This method returns the price of the property.
     * @return price
     */
    public int getPrice(){
        return price;
    }
}