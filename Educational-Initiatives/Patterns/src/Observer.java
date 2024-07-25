//Observer Pattern
//Use Case: Notifying subscribers about changes in a news feed.

import java.util.ArrayList;
import java.util.List;

// Subject
class NewsFeed {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setNews(String news) {
        this.news = news;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }
}

// Observer interface
interface Observer {
    void update(String news);
}

// Concrete Observer
class NewsReader implements Observer {
    private String name;

    public NewsReader(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}