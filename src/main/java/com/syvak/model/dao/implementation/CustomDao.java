package com.syvak.model.dao.implementation;

import com.syvak.model.entity.Custom;
import com.syvak.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomDao implements AbstractGenericDao<Custom> {
    public static final String TABLE = "syvak_lab.custom";
    private static final String GET_ALL_QUERY = "SELECT * FROM syvak_lab.custom;";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (id, date, duration_in_hours," +
            "address, cost_in_uah) VALUES (?, ?, ?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET id = ?, date = ?, duration_in_hours = ?," +
            "address = ?, cost_in_uah = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";


    @Override
    public List<Custom> findAll() {
        List<Custom> customs = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Custom custom = new Custom(
                        resultSet.getInt("id"),
                        resultSet.getString("date"),
                        resultSet.getInt("duration_in_hours"),
                        resultSet.getString("address"),
                        resultSet.getInt("cost_in_uah")
                );
                customs.add(custom);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customs;
    }


    @Override
    public Custom findOne(Integer id) {
        Custom custom = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                custom = new Custom(
                        resultSet.getInt("id"),
                        resultSet.getString("date"),
                        resultSet.getInt("duration_in_hours"),
                        resultSet.getString("address"),
                        resultSet.getInt("cost_in_uah")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return custom;
    }

    @Override
    public void create(Custom custom) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, String.valueOf(custom.getDate()));
            statement.setInt(2, Integer.valueOf(custom.getDuration_in_hours()));
            statement.setString(3, String.valueOf(custom.getAddress()));
            statement.setInt(4, Integer.valueOf(custom.getCost_in_uah()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Custom custom) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, custom.getDate());
            statement.setInt(2, custom.getDuration_in_hours());
            statement.setString(3, custom.getAddress());
            statement.setInt(4, custom.getCost_in_uah());
             statement.setInt(5, id);
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