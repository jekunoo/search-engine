package com.java.strukdat.searchengine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.java.strukdat.searchengine.model.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/landing-page.fxml"));

        primaryStage.setTitle("Search with Suggestions");
        primaryStage.setScene(new Scene(root, 1080, 720));
        primaryStage.show();
        populateRBT();
    }

    private void populateRBT(){
        RedBlackTree tree = TreeInstance.getInstance().getTree();
        tree.insert("Eagle", "A large bird of prey with sharp talons and keen eyesight.", "Majestic, powerful, swift");
        tree.insert("Laptop", "A portable personal computer with a keyboard and screen.", "Work, productivity, versatile");
        tree.insert("Moon", "Earth's natural satellite, visible at night, often associated with beauty.", "Celestial, mystical, serene");
        tree.insert("Shovel", "A tool with a broad blade used for digging, lifting, and moving material.", "Garden, excavation, tool");
        tree.insert("Piano", "A large musical instrument with black and white keys used for playing music.", "Music, art, sound");
        tree.insert("Firetruck", "A large vehicle equipped with firefighting equipment, used in emergencies.", "Emergency, rescue, safety");
        tree.insert("Rose", "A type of flower known for its beautiful petals and often symbolizing love.", "Romantic, fragrant, delicate");
        tree.insert("Diamond", "A precious gemstone formed under high pressure and heat, often used in jewelry.", "Luxury, timeless, valuable");
        tree.insert("Guitar", "A stringed musical instrument played by plucking or strumming.", "Music, melody, art");
        tree.insert("Cloud", "A mass of condensed water vapor that forms in the sky.", "Weather, float, ethereal");
        tree.insert("Dragon", "A mythical creature often depicted as a large, fire-breathing reptile.", "Fantasy, strength, power");
        tree.insert("Coffee", "A beverage made from roasted coffee beans, often consumed to boost energy.", "Caffeine, morning, refreshment");
        tree.insert("Chandelier", "A decorative light fixture that hangs from the ceiling, often adorned with crystals.", "Elegant, lighting, luxury");
        tree.insert("Cobra", "A venomous snake known for its hood and dangerous bite.", "Snake, poisonous, fierce");
        tree.insert("Laptop Charger", "A device used to supply power to a laptop through its charging port.", "Essential, power, technology");
        tree.insert("Telescope", "An instrument used to observe distant objects, typically in the sky.", "Astronomy, exploration, science");
        tree.insert("Bicycle", "A two-wheeled vehicle powered by pedaling, used for transportation and recreation.", "Environmentally friendly, exercise, transport");
        tree.insert("Suitcase", "A portable rectangular container used for storing clothes and personal items while traveling.", "Travel, luggage, convenience");
        tree.insert("Butterfly", "A colorful insect with large wings, known for its metamorphosis from caterpillar.", "Beauty, transformation, nature");
        tree.insert("Smartphone", "A mobile device with a touch screen that combines a phone with advanced features.", "Communication, entertainment, technology");
        tree.insert("Pine Tree", "A type of coniferous tree with long needle-like leaves, often associated with forests.", "Nature, evergreen, forest");
        tree.insert("Magnet", "An object that produces a magnetic field, attracting metal objects.", "Science, force, attraction");
        tree.insert("Kangaroo", "A large marsupial from Australia, known for its strong legs and hopping movement.", "Australia, animal, jump");
        tree.insert("Clock", "A device used to measure and display time.", "Time, punctuality, functionality");
        tree.insert("Submarine", "A watercraft capable of underwater operation, used in military or research contexts.", "Ocean, exploration, technology");
        tree.insert("Whale", "A large marine mammal known for its size and ability to live in the ocean.", "Marine, giant, mammal");
        tree.insert("Train", "A mode of transportation consisting of connected vehicles that run on tracks.", "Transport, travel, efficient");
        tree.insert("Laptop Stand", "A device used to elevate a laptop for ergonomic purposes.", "Work, health, productivity");
        tree.insert("Stethoscope", "A medical instrument used to listen to internal sounds of a patient's body.", "Health, doctor, diagnosis");
        tree.insert("Necklace", "A piece of jewelry worn around the neck, often made of metals or gemstones.", "Fashion, accessory, elegance");
        tree.insert("Candle", "A wax-based object that burns to provide light and often fragrance.", "Light, ambiance, relaxation");
        tree.insert("Giraffe", "A tall mammal from Africa known for its long neck and spots.", "Safari, tall, herbivore");
        tree.insert("Binoculars", "A device used for magnifying distant objects with two lenses.", "Outdoor, vision, observation");
        tree.insert("Laptop Sleeve", "A protective case for a laptop, typically made of fabric or leather.", "Protection, convenience, portable");
        tree.insert("Microscope", "An instrument used to magnify small objects, typically used in scientific research.", "Science, research, magnification");
        tree.insert("Penguin", "A flightless bird known for its black-and-white coloration and swimming ability.", "Antarctic, bird, aquatic");
        tree.insert("Hammock", "A suspended bed or couch made of fabric or netting, used for relaxing.", "Relaxation, outdoor, leisure");
        tree.insert("Helmet", "A protective headgear worn for safety, often during sports or riding.", "Safety, protection, gear");
        tree.insert("Laptop Bag", "A bag designed to carry and protect a laptop during travel.", "Portable, convenience, tech");
        tree.insert("Cactus", "A type of plant known for its thick, fleshy stem and spines, often found in deserts.", "Desert, plant, resilience");
        tree.insert("Dragonfly", "An insect with large wings and a long body, often seen near water.", "Nature, flight, beauty");
        tree.insert("Swan", "A large, graceful bird often associated with lakes and ponds.", "Elegance, nature, beauty");
        tree.insert("Wrench", "A tool used to tighten or loosen bolts and nuts.", "Hand tool, mechanic, essential");
        tree.insert("Dolphin", "A highly intelligent marine mammal known for its playful behavior.", "Ocean, intelligence, friendly");
        tree.insert("Turtle", "A slow-moving reptile with a hard shell that protects its body.", "Reptile, slow, nature");
        tree.insert("Stadium", "A large venue for sports events and concerts, typically with seating for many people.", "Sports, entertainment, large");
        tree.insert("Guitar Pick", "A small flat tool used to pluck the strings of a guitar.", "Music, instrument, accessory");
        tree.insert("Camera", "A device used for capturing photographs and videos.", "Photography, memories, technology");
        tree.insert("Lighthouse", "A tall structure with a light used to guide ships safely into ports.", "Maritime, safety, navigation");
        tree.insert("Dragon Scale", "A mythical item often depicted as part of a dragon's body in fantasy lore.", "Fantasy, mythical, treasure");
        tree.insert("Violin", "A string instrument played with a bow, known for its expressive sound.", "Music, instrument, classical");
        tree.insert("Anchor", "A heavy object used to secure a ship or boat in place.", "Maritime, ship, stability");
        tree.insert("Football", "A ball used in the sport of football, often made of leather or synthetic material.", "Sport, game, team");
        tree.insert("Lemonade", "A sweet beverage made from lemon juice, sugar, and water.", "Drink, refreshing, summer");
        tree.insert("Skateboard", "A board with wheels, used for riding and performing tricks.", "Sport, fun, recreation");
        tree.insert("Lantern", "A portable light source often used outdoors or during power outages.", "Light, outdoor, emergency");
        tree.insert("Key", "A small metal device used to unlock doors or start vehicles.", "Security, access, essential");
        tree.insert("Boots", "A type of footwear that covers the foot and ankle, often worn for outdoor activities.", "Footwear, protection, outdoor");
        tree.insert("Bridge", "A structure built to span a gap or obstacle, such as a river or road.", "Engineering, structure, transport");
        tree.insert("Hedgehog", "A small mammal with spines on its back, known for rolling into a ball when threatened.", "Animal, small, cute");
        tree.insert("Belt", "A strip of material worn around the waist to hold up pants or as a fashion accessory.", "Fashion, accessory, practical");
        tree.insert("Canoe", "A narrow, lightweight boat typically paddled by hand.", "Water, outdoor, recreation");
        tree.insert("Goggles", "Protective eyewear worn to shield the eyes from harmful substances or conditions.", "Safety, protection, outdoor");
        tree.insert("Shark", "A large predatory fish known for its sharp teeth and speed.", "Ocean, predator, dangerous");
        tree.insert("Helicopter", "A type of aircraft that can take off and land vertically.", "Flight, transport, rescue");
        tree.insert("Helmet Camera", "A small camera mounted on a helmet to record activity from the user's perspective.", "Recording, adventure, tech");
        tree.insert("Telescope Lens", "The lens of a telescope used to magnify distant objects.", "Astronomy, magnification, science");
        tree.insert("Rainbow", "A meteorological phenomenon caused by reflection, refraction, and dispersion of light.", "Nature, color, beauty");
        tree.insert("Whistle", "A small device used to produce a loud, high-pitched sound.", "Signal, attention, sports");
        tree.insert("Broom", "A cleaning tool with bristles used for sweeping floors.", "Cleaning, tool, household");
        tree.insert("Bat", "A flying mammal known for its nocturnal activity and use of echolocation.", "Animal, night, mammal");
        tree.insert("Torch", "A portable light source often used in outdoor or emergency situations.", "Light, outdoor, survival");
        tree.insert("Sunflower", "A tall, bright yellow flower known for its large size and seeds.", "Plant, nature, bright");
        tree.insert("Hammer", "A tool with a heavy head used for driving nails or breaking objects.", "Tool, construction, impact");
        tree.insert("Fountain", "A decorative feature in a garden or park, often with water flowing from it.", "Water, decor, relaxation");
        tree.insert("Bicycle Helmet", "A safety helmet worn while riding a bicycle to protect the head.", "Safety, bike, protection");
        tree.insert("A", "Value A", "Content A", () -> System.out.println("Action for A executed!"));
        tree.insert("B", "Value B", "Content B", () -> System.out.println("Action for B executed!"));
        tree.insert("C", "Value C", "Content C");

        tree.executeGimmickForKey("c");

    }

    public static void main(String[] args) {
        launch(args);
    }
}
