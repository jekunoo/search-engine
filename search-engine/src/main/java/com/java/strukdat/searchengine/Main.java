package com.java.strukdat.searchengine;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import com.java.strukdat.searchengine.model.*;

public class Main extends Application {

    @FXML
    private AnchorPane rootPane;

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
        // A
        tree.insert("Apple", "Apple is a fruit that comes in various colors like red, green, and yellow. It is known for its crisp texture and juicy sweetness. Apples are rich in dietary fiber and vitamin C.");
        tree.insert("Ant", "Ants are small insects that live in colonies. They are known for their teamwork and ability to carry objects many times their weight. Ants communicate through pheromones and are found worldwide.");
        tree.insert("Airplane", "An airplane is a mode of transport that flies through the air. It is powered by engines and is used for long-distance travel. Modern airplanes are equipped with advanced navigation systems.");
        tree.insert("Aquarium", "An aquarium is a tank filled with water for keeping fish and aquatic plants. It is often used for decorative purposes in homes and offices. Aquariums require maintenance for a healthy ecosystem.");
        tree.insert("Almond", "Almonds are a type of nut that are highly nutritious and rich in healthy fats, fiber, and protein. They are commonly used in desserts and as a snack. Almonds are also pressed to produce oil.");

// B
        tree.insert("Ball", "A ball is a round object used in various sports like soccer, basketball, and tennis. Balls are typically made of rubber, leather, or plastic and come in different sizes and weights.");
        tree.insert("Bear", "Bears are large mammals found in forests, mountains, and tundra regions. They have thick fur and are known for their strength. Bears are omnivores and often hibernate during the winter.");
        tree.insert("Butterfly", "Butterflies are colorful insects that go through a complete metamorphosis. They start as caterpillars and emerge as beautiful winged creatures. Butterflies play an important role in pollination.");
        tree.insert("Bicycle", "A bicycle is a two-wheeled vehicle powered by pedaling. It is an eco-friendly mode of transportation and a popular choice for recreation and exercise. Bicycles come in various styles and sizes.");
        tree.insert("Bridge", "A bridge is a structure built to span physical obstacles like rivers, valleys, or roads. It is essential for transportation and can be made of materials like steel, concrete, or wood.");

// C
        tree.insert("Cat", "Cats are small carnivorous mammals that are often kept as pets. They are known for their agility, playful behavior, and independent nature. Cats communicate through meows, purring, and body language.");
        tree.insert("Car", "A car is a motor vehicle used for transportation. Cars are designed to run on roads and typically have four wheels. They come in various models, offering a range of features and performance.");
        tree.insert("Camera", "A camera is a device used to capture photographs and videos. Modern cameras come with digital sensors and advanced features like autofocus and zoom. Cameras are widely used for professional and personal purposes.");
        tree.insert("Candle", "A candle is a source of light that uses a wick and wax. Candles are often used for decorative purposes, ceremonies, and creating ambiance. They come in various shapes, colors, and scents.");
        tree.insert("Chair", "A chair is a piece of furniture designed for sitting. It typically has a backrest and can be made of wood, metal, or plastic. Chairs are found in homes, offices, and public places.");

// D
        tree.insert("Dog", "Dogs are domesticated mammals known as man's best friend. They are loyal, intelligent, and used for companionship, work, and security. Dogs communicate through barks, whines, and tail wagging.");
        tree.insert("Desk", "A desk is a piece of furniture used for writing, working, or studying. It usually has a flat surface and drawers for storage. Desks come in various styles and sizes for home and office use.");
        tree.insert("Dolphin", "Dolphins are intelligent marine mammals known for their playful nature. They communicate through clicks and whistles. Dolphins are social animals and live in groups called pods.");
        tree.insert("Drum", "A drum is a musical instrument that produces sound by hitting a membrane. Drums are used in various music genres and are integral to rhythm sections in bands and orchestras.");
        tree.insert("Duck", "Ducks are waterfowl known for their quacking sounds. They have waterproof feathers and webbed feet, making them excellent swimmers. Ducks are commonly found near lakes, rivers, and ponds.");

// E
        tree.insert("Elephant", "Elephants are the largest land animals, known for their intelligence and social behavior. They have trunks for grasping objects and tusks for defense. Elephants live in herds led by a matriarch.");
        tree.insert("Eagle", "Eagles are large birds of prey known for their sharp eyesight and powerful flight. They are symbols of freedom and strength in many cultures. Eagles primarily feed on fish and small mammals.");
        tree.insert("Engine", "An engine is a machine that converts energy into mechanical motion. Engines are used in vehicles, machinery, and power plants. They come in various types, including internal combustion and electric.");
        tree.insert("Eraser", "An eraser is a stationery item used to remove pencil marks. Erasers are made of rubber or vinyl and come in various shapes and sizes. They are essential tools for writing and drawing.");
        tree.insert("Envelope", "An envelope is a flat paper container used for enclosing letters or documents. It protects the contents and allows them to be mailed securely. Envelopes are available in various sizes and colors.");
// F
        tree.insert("Fox", "Foxes are small to medium-sized mammals known for their agility and adaptability. They are found in diverse habitats, including forests, grasslands, and urban areas. Foxes are omnivores, feeding on fruits, small mammals, and insects. They are often depicted in folklore as cunning and clever.");
        tree.insert("Fish", "Fish are aquatic animals with gills, fins, and a streamlined body. They inhabit oceans, rivers, and lakes, playing a crucial role in the food chain. Fish are a significant source of protein for humans and contribute to the biodiversity of aquatic ecosystems.");
        tree.insert("Flower", "Flowers are the reproductive structures of flowering plants, known for their beauty and variety. They attract pollinators like bees, butterflies, and birds. Flowers symbolize various emotions and events and are widely used in decorations, ceremonies, and as gifts.");
        tree.insert("Fan", "A fan is a device used to circulate air and provide cooling. Fans are used in households, vehicles, and industrial settings. They range from handheld to large industrial fans and are essential for maintaining comfort and ventilation in various environments.");
        tree.insert("Forest", "Forests are large areas dominated by trees and other vegetation. They are vital for the environment, providing oxygen, storing carbon, and supporting biodiversity. Forests also offer resources like wood and medicinal plants and are home to numerous wildlife species.");

// G
        tree.insert("Goat", "Goats are domesticated animals raised for their milk, meat, and wool. They are known for their agility and ability to adapt to harsh environments. Goats have a curious and playful nature, making them popular in farming and even as pets.");
        tree.insert("Giraffe", "Giraffes are the tallest land animals, known for their long necks and legs. They are native to Africa and feed on leaves from tall trees like acacias. Giraffes are social animals that live in groups and are a symbol of grace and uniqueness.");
        tree.insert("Guitar", "A guitar is a stringed musical instrument used in various genres, including classical, rock, and pop. It can be acoustic or electric and is known for its versatility and ability to produce harmonious melodies and chords.");
        tree.insert("Glass", "Glass is a transparent material made from sand, soda ash, and limestone. It is used in windows, containers, and decorative items. Glass is valued for its clarity and ability to be shaped into various forms, making it versatile in applications.");
        tree.insert("Galaxy", "A galaxy is a massive system of stars, planets, dust, and gas bound together by gravity. The Milky Way, our home galaxy, contains billions of stars and planets. Galaxies come in different shapes and sizes, contributing to the vastness of the universe.");

// H
        tree.insert("Horse", "Horses are large mammals known for their speed, strength, and grace. They have been domesticated for thousands of years for transportation, agriculture, and companionship. Horses play an important role in various sports, such as racing and equestrian events.");
        tree.insert("Hawk", "Hawks are birds of prey with sharp talons and excellent eyesight. They hunt small animals and birds and are known for their swift and precise flight. Hawks are an essential part of the ecosystem, controlling populations of smaller species.");
        tree.insert("Hat", "A hat is a headwear used for protection, fashion, or cultural significance. Hats come in various styles, including caps, fedoras, and helmets, each serving specific purposes. They are often used as symbols of status or profession.");
        tree.insert("Honey", "Honey is a sweet, viscous substance produced by bees from flower nectar. It is widely used as a natural sweetener and has medicinal properties. Honey is rich in antioxidants and enzymes, making it a valuable ingredient in both food and skincare.");
        tree.insert("House", "A house is a building designed for people to live in. It provides shelter and security and is often considered a basic necessity. Houses come in various designs, reflecting cultural, environmental, and economic factors, and are an essential part of human life.");

// I
        tree.insert("Ice", "Ice is the solid form of water that occurs when temperatures drop below freezing. It is used for cooling, preserving food, and recreational activities like skating. Ice plays a crucial role in Earth's climate and ecosystems, especially in polar regions.");
        tree.insert("Island", "An island is a piece of land surrounded by water. Islands vary in size, from small islets to large landmasses like Greenland. They are often rich in biodiversity and are popular destinations for tourism and relaxation.");
        tree.insert("Iron", "Iron is a metallic element widely used in construction, manufacturing, and transportation. It is the primary component of steel and is known for its strength and durability. Iron is also essential for human health, playing a key role in oxygen transport in the blood.");
        tree.insert("Ink", "Ink is a liquid used for writing, drawing, and printing. It comes in various colors and is made from pigments or dyes suspended in a solvent. Ink has been used for centuries and is an essential medium for communication and art.");
        tree.insert("Iguana", "Iguanas are herbivorous lizards found in tropical areas of Central and South America. They are known for their long tails, sharp claws, and vibrant colors. Iguanas play a role in their ecosystems by feeding on plants and dispersing seeds.");
// J
        tree.insert("Jaguar", "Jaguars are large, powerful cats native to the Americas. They are known for their beautiful spotted coats and exceptional hunting skills. Jaguars play a key role in their ecosystems by maintaining the balance of prey populations.");
        tree.insert("Jellyfish", "Jellyfish are fascinating marine creatures with umbrella-shaped bodies and tentacles. They have existed for millions of years and are found in oceans worldwide. Despite their simplicity, they are efficient predators.");
        tree.insert("Jasmine", "Jasmine is a fragrant flowering plant often used in perfumes and teas. The delicate white or yellow flowers are associated with purity and elegance in many cultures.");
        tree.insert("Javelin", "A javelin is a lightweight spear designed for throwing in sports competitions. It requires skill, strength, and technique to achieve distance and precision.");
        tree.insert("Jackfruit", "Jackfruit is a tropical fruit known for its large size and sweet, fibrous flesh. It is versatile and used in both savory and sweet dishes in many cuisines.");

// K
        tree.insert("Koala", "Koalas are marsupials native to Australia, known for their fluffy ears and love for eucalyptus leaves. They spend most of their time sleeping in trees and are iconic symbols of Australian wildlife.");
        tree.insert("Kangaroo", "Kangaroos are large marsupials known for their strong hind legs and unique method of hopping. They are native to Australia and are known for carrying their young in pouches.");
        tree.insert("Kite", "A kite is a flying object tethered by a string, traditionally made from paper, fabric, and wood. It provides joy and entertainment to people of all ages.");
        tree.insert("Koi Fish", "Koi fish are colorful, ornamental fish often found in ponds and water gardens. They symbolize prosperity and good fortune in many cultures.");
        tree.insert("Keyboard", "A keyboard is an essential input device used for typing on computers. It comes in various layouts and is a vital tool for communication and work in the digital age.");

// L
        tree.insert("Lion", "Lions are majestic big cats known as the 'kings of the jungle.' They live in groups called prides and are famous for their impressive manes and powerful roars.");
        tree.insert("Lighthouse", "A lighthouse is a tower equipped with a bright light, designed to guide ships and warn them of hazards. They have been crucial in maritime navigation for centuries.");
        tree.insert("Lavender", "Lavender is a fragrant herb known for its calming properties. It is used in aromatherapy, cosmetics, and as a natural remedy for relaxation.");
        tree.insert("Lemur", "Lemurs are primates native to Madagascar. They are known for their expressive eyes and social behaviors, living in diverse habitats on the island.");
        tree.insert("Lizard", "Lizards are reptiles found in various habitats worldwide. They range from tiny geckos to large monitors and are known for their adaptability.");

// M
        tree.insert("Monkey", "Monkeys are intelligent primates found in tropical forests worldwide. They are social animals known for their playful behaviors and strong family bonds.");
        tree.insert("Mango", "Mangoes are sweet, juicy fruits popular in tropical regions. They are enjoyed fresh, in smoothies, or as part of many dishes and desserts.");
        tree.insert("Mountain", "Mountains are towering landforms rising above surrounding terrain. They are important for biodiversity and offer breathtaking views and challenging adventures.");
        tree.insert("Mouse", "Mice are small rodents found worldwide. Despite their size, they have played significant roles in science and culture.");
        tree.insert("Microscope", "Microscopes are scientific instruments that allow the observation of tiny objects and organisms, revolutionizing the study of biology and materials science.");

// N
        tree.insert("Narwhal", "Narwhals are unique marine mammals known as the 'unicorns of the sea.' They have long, spiral tusks and live in the Arctic Ocean.");
        tree.insert("Nest", "A nest is a structure built by birds, insects, or animals to house their young. It varies in design, from simple hollows to intricate woven creations.");
        tree.insert("Nightingale", "Nightingales are songbirds famous for their beautiful and melodious calls, often heard at night during the breeding season.");
        tree.insert("Nutmeg", "Nutmeg is a spice derived from the seed of a tropical tree. It is used in cooking and baking for its warm, sweet flavor.");
        tree.insert("Notebook", "Notebooks are essential tools for writing and organization. They are used for note-taking, journaling, and creative expressions.");

// O
        tree.insert("Owl", "Owls are nocturnal birds of prey known for their large eyes and ability to rotate their heads. They are symbols of wisdom and stealth.");
        tree.insert("Octopus", "Octopuses are intelligent marine creatures with eight arms and remarkable problem-solving skills. They can change color and texture to blend into their surroundings.");
        tree.insert("Orchid", "Orchids are beautiful and diverse flowers known for their intricate shapes and vibrant colors. They are highly prized in horticulture.");
        tree.insert("Otter", "Otters are playful aquatic mammals found in rivers and coasts. They are known for their intelligence and use of tools to open shells.");
        tree.insert("Orange", "Oranges are citrus fruits packed with vitamin C. They are enjoyed fresh, juiced, or as an ingredient in various dishes.");

// P
        tree.insert("Penguin", "Penguins are flightless birds adapted to life in the water. They are found in the Southern Hemisphere and are known for their waddling gait.");
        tree.insert("Peacock", "Peacocks are birds renowned for their vibrant plumage and eye-catching tail feathers. They symbolize beauty and pride in many cultures.");
        tree.insert("Pumpkin", "Pumpkins are large, orange fruits commonly used in cooking and as decorations during Halloween.");
        tree.insert("Panda", "Pandas are beloved bears native to China, known for their black and white fur and love of bamboo.");
        tree.insert("Pineapple", "Pineapples are tropical fruits with a sweet and tangy flavor, often used in desserts, drinks, and savory dishes.");
// Q
        tree.insert("Quail", "Quails are small, ground-dwelling birds known for their plump bodies and swift movements. They are found in various habitats and are valued for their eggs and meat.");
        tree.insert("Quartz", "Quartz is a common mineral found in the Earth's crust. It is used in jewelry, electronics, and as a decorative stone due to its beauty and durability.");
        tree.insert("Quokka", "Quokkas are small marsupials native to Australia, famous for their cheerful appearance and friendly nature, often dubbed the 'happiest animals on Earth.'");
        tree.insert("Quilt", "Quilts are handmade blankets consisting of layers of fabric stitched together. They are cherished as functional art and family heirlooms.");
        tree.insert("Quiver", "A quiver is a container used to hold arrows, traditionally carried by archers. It is an essential accessory in archery, symbolizing readiness and precision.");

// R
        tree.insert("Rabbit", "Rabbits are small mammals known for their long ears and powerful hind legs. They are popular pets and are also important in various ecosystems.");
        tree.insert("Rainbow", "A rainbow is a natural phenomenon that occurs when light is refracted through water droplets, creating a spectrum of colors in the sky.");
        tree.insert("Raccoon", "Raccoons are nocturnal mammals with distinctive black masks around their eyes. They are highly adaptable and known for their curiosity.");
        tree.insert("Rose", "Roses are iconic flowers symbolizing love and beauty. They come in various colors and are cultivated worldwide for their fragrance and appearance.");
        tree.insert("Rocket", "Rockets are vehicles propelled by engines that expel gas. They are essential in space exploration and scientific research.");

// S
        tree.insert("Shark", "Sharks are powerful marine predators with streamlined bodies and sharp teeth. They have existed for millions of years and play a vital role in marine ecosystems.");
        tree.insert("Sunflower", "Sunflowers are tall plants with large, bright yellow flowers that track the sun's movement. They are valued for their beauty and seeds.");
        tree.insert("Snake", "Snakes are legless reptiles with elongated bodies. They are found in diverse habitats and are both feared and admired for their unique adaptations.");
        tree.insert("Starfish", "Starfish are marine animals with radial symmetry and remarkable regenerative abilities. They are found in oceans worldwide.");
        tree.insert("Strawberry", "Strawberries are sweet, red fruits enjoyed fresh or in various desserts. They are rich in vitamins and antioxidants.");

// T
        tree.insert("Tiger", "Tigers are majestic big cats known for their striking orange and black stripes. They are apex predators and play a critical role in their ecosystems.");
        tree.insert("Tulip", "Tulips are brightly colored flowers that bloom in spring. They are a symbol of love and are widely cultivated for their beauty.");
        tree.insert("Turtle", "Turtles are reptiles with hard shells that protect them from predators. They are found in aquatic and terrestrial habitats.");
        tree.insert("Tractor", "Tractors are powerful vehicles used in farming and construction. They are essential tools for modern agriculture.");
        tree.insert("Table", "Tables are versatile pieces of furniture used for dining, work, and other activities. They come in various shapes and materials.");

// U
        tree.insert("Umbrella", "Umbrellas are portable devices used for protection against rain or sunlight. They are both practical and fashionable accessories.");
        tree.insert("Unicorn", "Unicorns are mythical creatures resembling horses with a single horn on their foreheads. They symbolize purity and magic.");
        tree.insert("Urchin", "Sea urchins are small, spiny marine animals that play an important role in underwater ecosystems. They feed on algae and serve as prey for larger species.");
        tree.insert("Ukulele", "The ukulele is a small, stringed instrument originating from Hawaii. It is known for its cheerful sound and is popular in various musical genres.");
        tree.insert("Uranium", "Uranium is a heavy metal used as a fuel in nuclear reactors. It is a critical element in energy production and scientific research.");

// V
        tree.insert("Vulture", "Vultures are scavenger birds that play a vital role in ecosystems by consuming carrion. They have keen eyesight and a strong sense of smell.");
        tree.insert("Volcano", "Volcanoes are geological formations that erupt molten rock, ash, and gases. They shape landscapes and influence the Earth's climate.");
        tree.insert("Vanilla", "Vanilla is a flavoring derived from the seeds of orchids. It is widely used in cooking, baking, and perfumery.");
        tree.insert("Violin", "The violin is a string instrument known for its expressive sound. It is used in various musical genres, from classical to folk.");
        tree.insert("Vase", "Vases are decorative containers used to hold flowers. They come in a wide range of shapes, sizes, and materials.");

// W
        tree.insert("Wolf", "Wolves are social predators known for their intelligence and pack behavior. They are found in forests, grasslands, and tundras.");
        tree.insert("Waterfall", "Waterfalls are natural formations where water flows over a vertical drop. They are breathtaking features in many landscapes.");
        tree.insert("Whale", "Whales are large marine mammals known for their intelligence and complex communication. They are essential for marine ecosystems.");
        tree.insert("Walnut", "Walnuts are nutrient-rich nuts often used in cooking and baking. They are valued for their health benefits and rich flavor.");
        tree.insert("Windmill", "Windmills are structures that convert wind energy into mechanical power. They have been used for grinding grain and pumping water for centuries.");

// X
        tree.insert("Xylophone", "The xylophone is a percussion instrument with wooden bars struck by mallets. It is used in both classical and contemporary music.");
        tree.insert("Xerus", "Xeruses are ground squirrels found in Africa. They are known for their burrowing habits and adaptability to arid environments.");
        tree.insert("X-ray", "X-rays are a type of electromagnetic radiation used in medical imaging and material analysis. They have revolutionized diagnostic techniques.");
        tree.insert("Xenops", "Xenops are small birds native to Central and South America. They are known for their unique beak shapes and tree-foraging habits.");
        tree.insert("Xanadu Plant", "The xanadu plant is a tropical houseplant known for its lush, green foliage. It is popular for indoor decoration.");

// Y
        tree.insert("Yak", "Yaks are sturdy, long-haired bovines native to the Himalayan region. They are used for transport, milk, and meat in high-altitude areas.");
        tree.insert("Yam", "Yams are starchy tubers grown in tropical regions. They are a staple food and are used in various culinary dishes.");
        tree.insert("Yellowfin Tuna", "Yellowfin tuna are large, fast-swimming fish found in tropical oceans. They are prized for their meat in the seafood industry.");
        tree.insert("Yo-yo", "A yo-yo is a toy consisting of a string and a spinning disc. It is used for entertainment and competitive tricks.");
        tree.insert("Yarrow", "Yarrow is a medicinal herb with feathery leaves and small flowers. It has been used in traditional remedies for centuries.");

// Z
        tree.insert("Zebra", "Zebras are striped animals native to Africa. Their unique patterns help them blend into grasslands and deter predators.");
        tree.insert("Zucchini", "Zucchini is a type of summer squash used in cooking. It is versatile and can be eaten raw, grilled, or baked.");
        tree.insert("Zenith", "Zenith refers to the highest point in the sky directly above an observer. It is also used metaphorically to signify a peak or climax.");
        tree.insert("Zephyr", "A zephyr is a gentle, soft breeze often associated with spring. The term is poetic and evokes a sense of tranquility.");
        tree.insert("Ziggurat", "Ziggurats are ancient, terraced structures built in Mesopotamia for religious purposes. They symbolize the connection between earth and the divine.");


//        gimmick
        tree.insert("Calculator", "Value calculator", "/com/java/strukdat/searchengine/view/component/Calc.fxml");
        tree.insert("Yes Or No?", "Cahyo Bingung?","/com/java/strukdat/searchengine/view/component/yesOrNo.fxml");
        tree.insert("Date","Tanggal adalah bla bla bla","/com/java/strukdat/searchengine/view/component/Date.fxml");


    }

    public static void main(String[] args) {
        launch(args);
    }
}
