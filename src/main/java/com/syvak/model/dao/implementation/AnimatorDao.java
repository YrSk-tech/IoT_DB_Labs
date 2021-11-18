package com.syvak.model.dao.implementation;

import com.syvak.model.entity.Animator;
import com.syvak.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimatorDao implements AbstractGenericDao<Animator> {
    public static final String TABLE = "syvak_lab.animator";
    private static final String GET_ALL_QUERY = "SELECT * FROM syvak_lab.animator;";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (name, surname, last_name, age) " +
            "VALUES (?, ?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET name = ?, surname = ? , last_name = ?, age = ?" +
            " WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";


    @Override
    public List<Animator> findAll() {
        List<Animator> animators = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Animator animator = new Animator(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age")
                );
                animators.add(animator);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return animators;
    }


    @Override
    public Animator findOne(Integer id) {
        Animator animator = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                animator = new Animator(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return animator;
    }

    @Override
    public void create(Animator animator) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, String.valueOf(animator.getName()));
            statement.setString(2, String.valueOf(animator.getSurname()));
            statement.setString(3, String.valueOf(animator.getLast_name()));
            statement.setInt(4, Integer.valueOf(animator.getAge()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Animator animator) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, animator.getName());
            statement.setString(2, animator.getSurname());
            statement.setString(2, animator.getSurname());
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