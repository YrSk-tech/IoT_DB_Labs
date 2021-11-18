package com.syvak.model.dao.implementation;

import com.syvak.model.entity.Award;
import com.syvak.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AwardDao implements AbstractGenericDao<Award> {
    public static final String TABLE = "syvak_lab.award";
    private static final String GET_ALL_QUERY = "SELECT * FROM syvak_lab.award;";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (name, year, nomination, agencyId) VALUES (?, ?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET name = ?, SET year = ?, SET nomination = ?, SET agencyId = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";


    @Override
    public List<Award> findAll() {
        List<Award> awardes = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Award award = new Award(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("year"),
                        resultSet.getString("nomination"),
                        resultSet.getInt("agency_id")
                );
                awardes.add(award);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return awardes;
    }


    @Override
    public Award findOne(Integer id) {
        Award award = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                award = new Award(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("year"),
                        resultSet.getString("nomination"),
                        resultSet.getInt("agency_Id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return award;
    }

    @Override
    public void create(Award award) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, String.valueOf(award.getName()));
            statement.setInt(2, Integer.valueOf(award.getYear()));
            statement.setString(3, String.valueOf(award.getNomination()));
            statement.setInt(4, Integer.valueOf(award.getAgencyId()));
            statement.executeUpdate();
            System.out.println(statement);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }




    @Override
    public void update(Integer id, Award award) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, award.getName());
            statement.setInt(2, award.getYear());
            statement.setString(3, award.getNomination());
            statement.setInt(4, award.getAgencyId());

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

