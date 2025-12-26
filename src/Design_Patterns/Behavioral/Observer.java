package Design_Patterns.Behavioral;

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface ObserverInterface {
    void update(String weather);
}

// Subject Interface
interface Subject {
    void addObserver(ObserverInterface observer);
    void removeObserver(ObserverInterface observer);
    void notifyObservers();
}

// ConcreteSubject Class
class WeatherStation implements Subject {
    private List<ObserverInterface> observers = new ArrayList<>();
    private String weather;

    @Override
    public void addObserver(ObserverInterface observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ObserverInterface observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ObserverInterface observer : observers) {
            observer.update(weather);
        }
    }

    public void setWeather(String newWeather) {
        this.weather = newWeather;
        notifyObservers();
    }
}

// ConcreteObserver Class
class PhoneDisplay implements ObserverInterface {
    private String weather;

    @Override
    public void update(String weather) {
        this.weather = weather;
        display();
    }

    private void display() {
        System.out.println("Phone Display: Weather updated - " + weather);
    }
}

// ConcreteObserver Class
class TVDisplay implements ObserverInterface {
    private String weather;

    @Override
    public void update(String weather) {
        this.weather = weather;
        display();
    }

    private void display() {
        System.out.println("TV Display: Weather updated - " + weather);
    }
}

// Usage Class
public class Observer {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        ObserverInterface phoneDisplay = new PhoneDisplay();
        ObserverInterface tvDisplay = new TVDisplay();

        // Register observers
        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(tvDisplay);

        // Simulating weather changes
        weatherStation.setWeather("Sunny");
        weatherStation.setWeather("Rainy");
        weatherStation.setWeather("Cloudy");

        // Remove one observer
        weatherStation.removeObserver(tvDisplay);

        // Notify remaining observer
        weatherStation.setWeather("Windy");
    }
}