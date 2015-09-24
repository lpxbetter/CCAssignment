import java.util.LinkedList;

/**
 * Created by lipingxiong on 9/22/15.
 */
public class AnimalShelter_3_6 {
    abstract class Animal {
        private int order;
        protected String name;

        public Animal(String n) {
            name = n;
        }

        public void setOrder(int ord) {
            order = ord;
        }

        public int getOrder() {
            return order;
        }

        public boolean isOlderThan(Animal a) {
            return this.order < a.getOrder();
        }
    }
    class Dog extends Animal{
         Dog(String n){
            super(n);
         }
    }
    class Cat extends Animal{
        Cat(String n){
            super(n);
        }
    }

    class AnimalQueue {
        LinkedList<Dog> dogs = new LinkedList<Dog>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        private int order = 0;

        public void enqueue(Animal a) {
            a.setOrder(order);
            order++;
            if (a instanceof Dog) dogs.addLast((Dog) a);
            else if (a instanceof Cat) cats.addLast((Cat) a);
        }

        public Animal dequeueAny() {
            if (dogs.size() == 0) {
                return dequeueCats();
            } else if(cats.size() == 0){
                return dequeueDogs();
            }
            Dog dog = dogs.peek();
            Cat cat = cats.peek();
            if(dog.isOlderThan(cat)){
                return dequeueDogs();
            }
            else return dequeueCats();
        }


        public Dog dequeueDogs() {
            return dogs.poll();
        }

        public Cat dequeueCats(){
            return cats.poll();
        }
    }
}
