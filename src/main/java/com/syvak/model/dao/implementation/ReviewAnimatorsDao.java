package com.syvak.model.dao.implementation;

import com.syvak.model.entity.ReviewAnimators;
import com.syvak.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewAnimatorsDao implements AbstractGenericDao<ReviewAnimators> {
    public static final String TABLE = "syvak_lab.review_animator";
    private static final String GET_ALL_QUERY = "SELECT * FROM syvak_lab.review_animator;";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (author, text, animator_id) VALUES (?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET author = ?, text = ?, animator_id = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";


    @Override
    public List<ReviewAnimators> findAll() {
        List<ReviewAnimators> reviewAnimators = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ReviewAnimators reviewAnimator = new ReviewAnimators(
                        resultSet.getInt("id"),
                        resultSet.getString("author"),
                        resultSet.getString("text"),
                        resultSet.getInt("animator_id")
                );
                reviewAnimators.add(reviewAnimator);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviewAnimators;
    }


    @Override
    public ReviewAnimators findOne(Integer id) {
        ReviewAnimators reviewAnimator = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                reviewAnimator = new ReviewAnimators(
                        resultSet.getInt("id"),
                        resultSet.getString("author"),
                        resultSet.getString("text"),
                        resultSet.getInt("animator_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviewAnimator;
    }

    @Override
    public void create(ReviewAnimators reviewAnimator) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, String.valueOf(reviewAnimator.getAuthor()));
            statement.setString(2, String.valueOf(reviewAnimator.getText()));
            statement.setInt(3, Integer.valueOf(reviewAnimator.getAnimator_id()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, ReviewAnimators reviewAnimator) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, reviewAnimator.getAuthor());
            statement.setString(2, reviewAnimator.getText());
            statement.setInt(3, reviewAnimator.getAnimator_id());
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
