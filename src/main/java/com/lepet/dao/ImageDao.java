package com.lepet.dao;

import com.lepet.model.Image;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImageDao {
    private static ImageDao instance;
    private List<Image> images = new ArrayList<>();
    private int id = 0;
    public static  synchronized ImageDao getInstance() throws SQLException {
        if (instance == null){
            instance = new ImageDao();
        }
        return instance;
    }
    private Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ImageDao () throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test2",
                "postgres",
                "");
        createImagesTable();
    }

    private void createImagesTable() throws SQLException {
        try(Statement statement = connection.createStatement()){
            statement.execute("CREATE TABLE IF NOT EXISTS images (\n" +
                    "id PRIMARY KEY,\n" +
                    "image \n" +
                    "aboutImage \n" +
                    ");");
        }
    }
    private void insertImage (Image image) throws SQLException {
        try(Statement statement = connection.createStatement()){
            String request = String.format("INSERT INTO images VALUES ('%s', '%s', '%d');",
                    image.getId(), image.getImage(), image.getAboutImage());
            statement.execute(request);
        }
    }



    public void addImage(Image image){
        images.add(image);
    }
    public int generateId(){
        id++;
        return id;
    }

    public List<Image> getAllImages() {
        return images;
    }
}
