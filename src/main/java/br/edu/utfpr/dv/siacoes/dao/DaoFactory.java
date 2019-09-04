package br.edu.utfpr.dv.siacoes.dao;

public class DaoFactory {

    public static IDaoFactory getDAO(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }

        switch (type) {
        case "Country":
            return new CountryDAO();
        case "State":
            return new StateDAO();
        case "City":
            return new CityDAO();
        }

        return null;
    }
}