package com.syvak.model.dao.implementation;

import com.syvak.model.entity.Holiday;
import com.syvak.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HolidayDao implements AbstractGenericDao<Holiday> {
    public static final String TABLE = "syvak_lab.holiday";
    private static final String GET_ALL_QUERY = "SELECT * FROM syvak_lab.holiday;";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (type, number_of_animators, number_of_participants, custom_id) VALUES (?, ?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET type = ?, number_of_animators = ?, SET number_of_participants = ?, SET custom_id = ?, WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";


    @Override
    public List<Holiday> findAll() {
        List<Holiday> holidays = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Holiday holiday = new Holiday(
                        resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getInt("number_of_animators"),
                        resultSet.getInt("number_of_participants"),
                        resultSet.getInt("custom_id")
                );
                holidays.add(holiday);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return holidays;
    }


    @Override
    public Holiday findOne(Integer id) {
        Holiday holiday = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                holiday = new Holiday(
                        resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getInt("number_of_animators"),
                        resultSet.getInt("number_of_participants"),
                        resultSet.getInt("custom_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return holiday;
    }

    @Override
    public void create(Holiday holiday) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, String.valueOf(holiday.getType()));
            statement.setInt(2, Integer.valueOf(holiday.getNumber_of_animators()));
            statement.setInt(3, Integer.valueOf(holiday.getNumber_of_participants()));
            statement.setInt(4, Integer.valueOf(holiday.getCustom_id()));

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Holiday holiday) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, holiday.getType());
            statement.setInt(2, holiday.getNumber_of_animators());
            statement.setInt(3, holiday.getNumber_of_participants());
            statement.setInt(4, holiday.getCustom_id());

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
