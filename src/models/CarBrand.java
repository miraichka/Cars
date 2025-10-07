package models;

public enum CarBrand {
    MERSEDES,
    PORSHE,
    BMW,
    LADA;

    public String brandic () {

        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
