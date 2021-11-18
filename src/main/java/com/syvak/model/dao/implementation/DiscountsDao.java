package com.syvak.model.dao.implementation;

import com.syvak.model.entity.Discounts;
import com.syvak.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscountsDao implements AbstractGenericDao<Discounts> {
    public static final String TABLE = "syvak_lab.discounts";
    private static final String GET_ALL_QUERY = "SELECT * FROM syvak_lab.discounts;";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (name, cost, agency_id ) VALUES (?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET name = ?, cost = ?, agency_id = ?  WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";


    @Override
    public List<Discounts> findAll() {
        List<Discounts> discounts = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Discounts discount = new Discounts(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getFloat("cost"),
                        resultSet.getInt("agency_id")
                );
                discounts.add(discount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return discounts;
    }


    @Override
    public Discounts findOne(Integer id) {
        Discounts discount = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                discount = new Discounts(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getFloat("cost"),
                        resultSet.getInt("agency_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return discount;
    }

    @Override
    public void create(Discounts discount) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, String.valueOf(discount.getName()));
            statement.setFloat(2, Float.valueOf(discount.getCost()));
            statement.setInt(3, Integer.valueOf(discount.getAgency_id()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Discounts discount) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, discount.getName());
            statement.setFloat(2, discount.getCost());
            statement.setInt(3, discount.getAgency_id());
            statement.setInt(4, id);
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