package com.example.listycity;
import org.junit.jupiter.api.Test;
import org.jetbrains.annotations.Contract;
import static org.junit.jupiter.api.Assertions.*;


class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    @Contract(value = "-> new", pure = true)
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void  testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(1, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();

        City calgary = mockCity();
        assertTrue(cityList.hasCity(calgary));

        City edmonton = new City("Edmonton", "Calgary");
        assertFalse(cityList.hasCity(edmonton));

        cityList.add(edmonton);
        assertTrue(cityList.hasCity(edmonton));

    }


    @Test
    void testDelete() {
        CityList cityList = mockCityList();

        City saskatoon = new City("Saskatoon", "Saskatchewan");
        cityList.add(saskatoon);

        assertEquals(2, cityList.countTotal());

        cityList.delete(saskatoon);
        assertEquals(1, cityList.countTotal());
        assertFalse(cityList.hasCity(saskatoon));

        assertTrue(cityList.hasCity(mockCity()));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();

        City toronto = new City("Toronto", "Ontario");

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(toronto);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();

        assertEquals(0, cityList.countTotal());

        cityList.add(mockCity());
        assertEquals(1, cityList.countTotal());

        cityList.add(new City("Vancouver", "British Columbia"));
        assertEquals(2, cityList.countTotal());

        cityList.add(new City("Halifax", "Nova Scotia"));
        assertEquals(3, cityList.countTotal());

        cityList.delete(mockCity());
        assertEquals(2, cityList.countTotal());
    }
}



