package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.StokKart;



public class StokKartDAO {

    public void saveStokKart(StokKart stokKart) {
        try (Connection connection = Constant.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO stokkartlari(StokKodu, StokAdi, StokTipi, Birimi, Barkodu, KDVTipi, Aciklama, OlusturmaZamani) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
             )) {

            preparedStatement.setString(1, stokKart.getStokKodu());
            preparedStatement.setString(2, stokKart.getStokAdi());
            preparedStatement.setInt(3, stokKart.getStokTipi());
            preparedStatement.setString(4, stokKart.getBirimi());
            preparedStatement.setString(5, stokKart.getBarkodu());
            preparedStatement.setDouble(6, stokKart.getKDVTipi());
            preparedStatement.setString(7, stokKart.getAciklama());
            preparedStatement.setTimestamp(8, new Timestamp(stokKart.getOlusturmaZamani().getTime()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStokKart(String stokKodu) {
        try (Connection connection = Constant.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM stokkartlari WHERE StokKodu = ?"
             )) {

            preparedStatement.setString(1, stokKodu);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStokKart(StokKart stokKart) {
        try (Connection connection = Constant.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE stokkartlari SET StokAdi = ?, StokTipi = ?, Birimi = ?, Barkodu = ?, KDVTipi = ?, Aciklama = ?, OlusturmaZamani = ? WHERE StokKodu = ?"
             )) {

            preparedStatement.setString(1, stokKart.getStokAdi());
            preparedStatement.setInt(2, stokKart.getStokTipi());
            preparedStatement.setString(3, stokKart.getBirimi());
            preparedStatement.setString(4, stokKart.getBarkodu());
            preparedStatement.setDouble(5, stokKart.getKDVTipi());
            preparedStatement.setString(6, stokKart.getAciklama());
            preparedStatement.setTimestamp(7, new Timestamp(stokKart.getOlusturmaZamani().getTime()));
            preparedStatement.setString(8, stokKart.getStokKodu());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<StokKart> getAllStokKartlar() {
        List<StokKart> stokKartlar = new ArrayList<>();

        try (Connection connection = Constant.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM stokkartlari")) {

            while (resultSet.next()) {
                StokKart stokKart = new StokKart();
                stokKart.setId(resultSet.getInt("id"));
                stokKart.setStokKodu(resultSet.getString("StokKodu"));
                stokKart.setStokAdi(resultSet.getString("StokAdi"));
                stokKart.setStokTipi(resultSet.getInt("StokTipi"));
                stokKart.setBirimi(resultSet.getString("Birimi"));
                stokKart.setBarkodu(resultSet.getString("Barkodu"));
                stokKart.setKDVTipi(resultSet.getDouble("KDVTipi"));
                stokKart.setAciklama(resultSet.getString("Aciklama"));
                stokKart.setOlusturmaZamani(resultSet.getTimestamp("OlusturmaZamani"));

                stokKartlar.add(stokKart);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stokKartlar;
    }

    public StokKart getStokKartByKodu(String stokKodu) {
        StokKart stokKart = null;

        try (Connection connection = Constant.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM stokkartlari WHERE StokKodu = ?")) {

            preparedStatement.setString(1, stokKodu);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    stokKart = new StokKart();
                    stokKart.setId(resultSet.getInt("id"));
                    stokKart.setStokKodu(resultSet.getString("StokKodu"));
                    stokKart.setStokAdi(resultSet.getString("StokAdi"));
                    stokKart.setStokTipi(resultSet.getInt("StokTipi"));
                    stokKart.setBirimi(resultSet.getString("Birimi"));
                    stokKart.setBarkodu(resultSet.getString("Barkodu"));
                    stokKart.setKDVTipi(resultSet.getDouble("KDVTipi"));
                    stokKart.setAciklama(resultSet.getString("Aciklama"));
                    stokKart.setOlusturmaZamani(resultSet.getTimestamp("OlusturmaZamani"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stokKart;
    }
    
    public StokKart getStokKartById(int stokId) {
        StokKart stokKart = null;

        try (Connection connection = Constant.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM stokkartlari WHERE id = ?")) {

            preparedStatement.setInt(1, stokId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    stokKart = new StokKart();
                    stokKart.setId(resultSet.getInt("id"));
                    stokKart.setStokKodu(resultSet.getString("StokKodu"));
                    stokKart.setStokAdi(resultSet.getString("StokAdi"));
                    stokKart.setStokTipi(resultSet.getInt("StokTipi"));
                    stokKart.setBirimi(resultSet.getString("Birimi"));
                    stokKart.setBarkodu(resultSet.getString("Barkodu"));
                    stokKart.setKDVTipi(resultSet.getDouble("KDVTipi"));
                    stokKart.setAciklama(resultSet.getString("Aciklama"));
                    stokKart.setOlusturmaZamani(resultSet.getTimestamp("OlusturmaZamani"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stokKart;
    }

}
