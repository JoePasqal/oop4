import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Homework {

  public static void main(String[] args) {
  }

  static class Box<T extends Fruit> implements Iterable<T> {
    private final List<T> fruits = new ArrayList<>();
    private final Class<T> type;

    public Box(Class<T> type) {
      this.type = type;
    }

    public void add(T fruit) {
      if (type.isInstance(fruit)) {
        fruits.add(fruit);
      } else {
        throw new IllegalArgumentException("Неверный тип фрукта");
      }
    }

    public int getWeight() {
      return fruits.stream().mapToInt(Fruit::getWeight).sum();
    }

    public void move(Box<? super T> another) {
      if (this.type.equals(another.type)) {
        another.fruits.addAll(this.fruits);
        this.fruits.clear();
      } else {
        throw new IllegalArgumentException("Нельзя пересыпать разные типы фруктов");
      }
    }

    @Override
    public Iterator<T> iterator() {
      return fruits.iterator();
    }
  }

  static class Fruit {
    private final int weight;

    public Fruit(int weight) {
      this.weight = weight;
    }

    public int getWeight() {
      return weight;
    }
  }

  static class Apple extends Fruit {
    public Apple(int weight) {
      super(weight);
    }
  }

  static class GoldenApple extends Apple {
    public GoldenApple(int weight) {
      super(weight);
    }
  }

  static class Orange extends Fruit {
    public Orange(int weight) {
      super(weight);
    }
  }

}
