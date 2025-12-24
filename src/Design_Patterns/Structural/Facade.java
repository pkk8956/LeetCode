package Design_Patterns.Structural;

// Интерфейс меню
interface Menus {}

// Конкретные меню
class VegMenu implements Menus {
    @Override
    public String toString() {
        return "Veg Menu";
    }
}

class NonVegMenu implements Menus {
    @Override
    public String toString() {
        return "Non-Veg Menu";
    }
}

class BothMenu implements Menus {
    @Override
    public String toString() {
        return "Both Veg & Non-Veg Menu";
    }
}

// Интерфейс ресторана
interface Hotel {
    Menus getMenus();
}

// Конкретные рестораны
class NonVegRestaurant implements Hotel {
    public Menus getMenus() {
        return new NonVegMenu();
    }
}

class VegRestaurant implements Hotel {
    public Menus getMenus() {
        return new VegMenu();
    }
}

class VegNonBothRestaurant implements Hotel {
    public Menus getMenus() {
        return new BothMenu();
    }
}

// Интерфейс хранителя меню (Facade)
interface HotelKeeper {
    VegMenu getVegMenu();
    NonVegMenu getNonVegMenu();
    BothMenu getVegNonMenu();
}

// Реализация хранителя меню
class HotelKeeperImplementation implements HotelKeeper {

    public VegMenu getVegMenu() {
        VegRestaurant v = new VegRestaurant();
        return (VegMenu)v.getMenus();
    }

    public NonVegMenu getNonVegMenu() {
        NonVegRestaurant nv = new NonVegRestaurant();
        return (NonVegMenu)nv.getMenus();
    }

    public BothMenu getVegNonMenu() {
        VegNonBothRestaurant b = new VegNonBothRestaurant();
        return (BothMenu)b.getMenus();
    }
}

// Класс Facade
public class Facade {
    public static void main(String[] args) {
        HotelKeeper keeper = new HotelKeeperImplementation();

        VegMenu v = keeper.getVegMenu();
        NonVegMenu nv = keeper.getNonVegMenu();
        BothMenu both = keeper.getVegNonMenu();

        System.out.println(v);
        System.out.println(nv);
        System.out.println(both);
    }
}
