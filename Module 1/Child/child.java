package Child;
import Parent_pack.*;

public class child extends parent{
    public void show() {
        System.out.println(num);
        display();
    }

        public static void main(String[] args) {
            child obj = new child();
            obj.show();
        }
    }

