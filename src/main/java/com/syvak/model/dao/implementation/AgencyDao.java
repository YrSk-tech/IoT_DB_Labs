package com.syvak.model.dao.implementation;

import com.syvak.model.entity.Agency;
import com.syvak.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgencyDao implements AbstractGenericDao<Agency> {
    public static final String TABLE = "syvak_lab.agency";
    private static final String GET_ALL_QUERY = "SELECT * FROM syvak_lab.agency;";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (name, phone_number) VALUES (?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET name = ?, phone_number = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";


    @Override
    public List<Agency> findAll() {
        List<Agency> agencies = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Agency agency = new Agency(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("phone_number")
                );
                agencies.add(agency);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agencies;
    }


    @Override
    public Agency findOne(Integer id) {
        Agency avatar = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                avatar = new Agency(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("phone_number")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return avatar;
    }

    @Override
    public void create(Agency agency) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setInt(1, Integer.valueOf(agency.getId()));
            statement.setString(2, String.valueOf(agency.getName()));
            statement.setInt(3, Integer.valueOf(agency.getPhone_number()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Agency agency) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, agency.getName());
            statement.setFloat(2, agency.getPhone_number());
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
