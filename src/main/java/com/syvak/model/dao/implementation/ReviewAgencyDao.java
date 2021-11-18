package com.syvak.model.dao.implementation;

import com.syvak.model.entity.ReviewAgency;
import com.syvak.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewAgencyDao implements AbstractGenericDao<ReviewAgency> {
    public static final String TABLE = "syvak_lab.review_agency";
    private static final String GET_ALL_QUERY = "SELECT * FROM syvak_lab.review_agency;";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (author, text, agency_id) " +
            "VALUES (?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET author = ?, text = ?, agency_id = ?" +
            " WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";


    @Override
    public List<ReviewAgency> findAll() {
        List<ReviewAgency> reviewAgencies = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ReviewAgency reviewAgency = new ReviewAgency(
                        resultSet.getInt("id"),
                        resultSet.getString("author"),
                        resultSet.getString("text"),
                        resultSet.getInt("agency_id")
                );
                reviewAgencies.add(reviewAgency);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviewAgencies;
    }


    @Override
    public ReviewAgency findOne(Integer id) {
        ReviewAgency reviewAgency = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                reviewAgency = new ReviewAgency(
                        resultSet.getInt("id"),
                        resultSet.getString("author"),
                        resultSet.getString("text"),
                        resultSet.getInt("agency_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviewAgency;
    }

    @Override
    public void create(ReviewAgency reviewAgency) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, String.valueOf(reviewAgency.getAuthor()));
            statement.setString(2, String.valueOf(reviewAgency.getText()));
            statement.setInt(3, Integer.valueOf(reviewAgency.getAgencyId()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, ReviewAgency reviewAgency) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, reviewAgency.getAuthor());
            statement.setString(2, reviewAgency.getText());
            statement.setInt(3, reviewAgency.getAgencyId());
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