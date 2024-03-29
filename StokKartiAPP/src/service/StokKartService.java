package service;

import dao.StokKartDAO;
import model.StokKart;

import java.util.List;

public class StokKartService {
    private final StokKartDAO stokKartDAO;

    public StokKartService() {
        this.stokKartDAO = new StokKartDAO();
    }

    public void addStokKart(StokKart stokKart) {
        stokKartDAO.saveStokKart(stokKart);
    }

    public void deleteStokKart(String stokKodu) {
        stokKartDAO.deleteStokKart(stokKodu);
    }

    public void updateStokKart(StokKart stokKart) {
        stokKartDAO.updateStokKart(stokKart);
    }

    public List<StokKart> getAllStokKartlar() {
        return stokKartDAO.getAllStokKartlar();
    }

    public StokKart getStokKartByKodu(String stokKodu) {
        return stokKartDAO.getStokKartByKodu(stokKodu);
    }
    
    public StokKart getStokKartByid(int stokid) {
        return stokKartDAO.getStokKartById(stokid);
    }
    
}
