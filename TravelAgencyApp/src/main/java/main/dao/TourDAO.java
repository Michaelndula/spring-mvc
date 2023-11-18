package main.dao;

import main.model.Tour;

import java.util.List;

public interface TourDAO {

    public List<Tour> getAll();

    public Tour getById(int id);

    public void saveOrUpdate(Tour tour);

    public void delete(int id);
}
