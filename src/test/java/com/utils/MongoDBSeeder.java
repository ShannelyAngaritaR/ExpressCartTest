package com.utils;
import com.config.MongoDBConnection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class MongoDBSeeder {
    private MongoDatabase database;

    public MongoDBSeeder() {
        // Obtener la instancia de la base de datos desde MongoDBConnection
        this.database = MongoDBConnection.getDatabase();
    }

    public void seedProducts() {
        MongoCollection<Document> collection = database.getCollection("products");

        // Crear documentos para los productos
        Document product1 = new Document("_id", "67230c0bbeeb9a1d58c8c040")
                .append("productPermalink", "shoes")
                .append("productTitle", "Shoes")
                .append("productPrice", "2500.00")
                .append("productDescription", "<p>zapatos comodos y elegantes</p>")
                .append("productGtin", "1236456")
                .append("productBrand", "GrandShoes")
                .append("productPublished", true)
                .append("productTags", "Zapatos")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T04:48:11.804Z")
                .append("productStock", 50)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product2 = new Document("_id", "654321abcde")
                .append("productPermalink", "bag")
                .append("productTitle", "Bag")
                .append("productPrice", "1500.00")
                .append("productDescription", "<p>Bolso espacioso y elegante</p>")
                .append("productGtin", "654321")
                .append("productBrand", "BrandBag")
                .append("productPublished", true)
                .append("productTags", "accessories")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T05:00:00.000Z")
                .append("productStock", 50)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product3 = new Document("_id", "987654xyz")
                .append("productPermalink", "jacket")
                .append("productTitle", "Jacket")
                .append("productPrice", "3000.00")
                .append("productDescription", "<p>Chaqueta para el invierno</p>")
                .append("productGtin", "987654")
                .append("productBrand", "CoolBrand")
                .append("productPublished", true)
                .append("productTags", "clothing")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T05:15:00.000Z")
                .append("productStock", 30)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product4 = new Document("_id", "12345678abc")
                .append("productPermalink", "hat")
                .append("productTitle", "Hat")
                .append("productPrice", "800.00")
                .append("productDescription", "<p>Gorra de verano</p>")
                .append("productGtin", "111111")
                .append("productBrand", "HatBrand")
                .append("productPublished", true)
                .append("productTags", "accessories")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T05:30:00.000Z")
                .append("productStock", 100)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product5 = new Document("_id", "23456789abc")
                .append("productPermalink", "watch")
                .append("productTitle", "Watch")
                .append("productPrice", "5000.00")
                .append("productDescription", "<p>Reloj de lujo</p>")
                .append("productGtin", "222222")
                .append("productBrand", "LuxuryTime")
                .append("productPublished", true)
                .append("productTags", "accessories")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T05:45:00.000Z")
                .append("productStock", 20)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product6 = new Document("_id", "34567890abc")
                .append("productPermalink", "belt")
                .append("productTitle", "Belt")
                .append("productPrice", "600.00")
                .append("productDescription", "<p>Cinturón de cuero</p>")
                .append("productGtin", "333333")
                .append("productBrand", "LeatherWorks")
                .append("productPublished", true)
                .append("productTags", "accessories")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T06:00:00.000Z")
                .append("productStock", 200)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product7 = new Document("_id", "45678901abc")
                .append("productPermalink", "socks")
                .append("productTitle", "Socks")
                .append("productPrice", "200.00")
                .append("productDescription", "<p>Calcetines cómodos</p>")
                .append("productGtin", "444444")
                .append("productBrand", "SockBrand")
                .append("productPublished", true)
                .append("productTags", "clothing")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T06:15:00.000Z")
                .append("productStock", 300)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product8 = new Document("_id", "56789012abc")
                .append("productPermalink", "gloves")
                .append("productTitle", "Gloves")
                .append("productPrice", "900.00")
                .append("productDescription", "<p>Guantes de invierno</p>")
                .append("productGtin", "555555")
                .append("productBrand", "GloveCo")
                .append("productPublished", true)
                .append("productTags", "clothing")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T06:30:00.000Z")
                .append("productStock", 120)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product9 = new Document("_id", "67890123abc")
                .append("productPermalink", "scarf")
                .append("productTitle", "Scarf")
                .append("productPrice", "1200.00")
                .append("productDescription", "<p>Bufanda de lana</p>")
                .append("productGtin", "666666")
                .append("productBrand", "WinterWarm")
                .append("productPublished", true)
                .append("productTags", "clothing")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T06:45:00.000Z")
                .append("productStock", 60)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product10 = new Document("_id", "78901234abc")
                .append("productPermalink", "sunglasses")
                .append("productTitle", "Sunglasses")
                .append("productPrice", "3500.00")
                .append("productDescription", "<p>Gafas de sol</p>")
                .append("productGtin", "777777")
                .append("productBrand", "SunGuard")
                .append("productPublished", true)
                .append("productTags", "accessories")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T07:00:00.000Z")
                .append("productStock", 80)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product11 = new Document("_id", "78901235abc")
                .append("productPermalink", "sunglassesRosse")
                .append("productTitle", "Sunglasses")
                .append("productPrice", "3500.00")
                .append("productDescription", "<p>Gafas de sol Rosa</p>")
                .append("productGtin", "777777")
                .append("productBrand", "SunGuard")
                .append("productPublished", true)
                .append("productTags", "accessories")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T07:00:00.000Z")
                .append("productStock", 80)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product12 = new Document("_id", "89012346abc")
                .append("productPermalink", "tshirt")
                .append("productTitle", "T-Shirt")
                .append("productPrice", "1200.00")
                .append("productDescription", "<p>Camiseta de algodón cómoda</p>")
                .append("productGtin", "888888")
                .append("productBrand", "ComfortWear")
                .append("productPublished", true)
                .append("productTags", "clothing")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T07:15:00.000Z")
                .append("productStock", 150)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product13 = new Document("_id", "90123457abc")
                .append("productPermalink", "jeans")
                .append("productTitle", "Jeans")
                .append("productPrice", "2000.00")
                .append("productDescription", "<p>Jeans de mezclilla clásica</p>")
                .append("productGtin", "999999")
                .append("productBrand", "DenimWorks")
                .append("productPublished", true)
                .append("productTags", "clothing")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T07:30:00.000Z")
                .append("productStock", 100)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product14 = new Document("_id", "012345678abc")
                .append("productPermalink", "sneakers")
                .append("productTitle", "Sneakers")
                .append("productPrice", "2200.00")
                .append("productDescription", "<p>Tenis deportivos para el día a día</p>")
                .append("productGtin", "111222")
                .append("productBrand", "ActiveStep")
                .append("productPublished", true)
                .append("productTags", "footwear")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T07:45:00.000Z")
                .append("productStock", 200)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product15 = new Document("_id", "12345674abc")
                .append("productPermalink", "blouse")
                .append("productTitle", "Blouse")
                .append("productPrice", "1800.00")
                .append("productDescription", "<p>Blusa elegante de seda</p>")
                .append("productGtin", "333444")
                .append("productBrand", "ElegantWear")
                .append("productPublished", true)
                .append("productTags", "clothing")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T08:00:00.000Z")
                .append("productStock", 50)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product16 = new Document("_id", "23456780abc")
                .append("productPermalink", "ring")
                .append("productTitle", "Ring")
                .append("productPrice", "4500.00")
                .append("productDescription", "<p>Anillo de plata con diamantes</p>")
                .append("productGtin", "555666")
                .append("productBrand", "JewelryLux")
                .append("productPublished", true)
                .append("productTags", "accessories")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T08:15:00.000Z")
                .append("productStock", 20)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product17 = new Document("_id", "34567891abc")
                .append("productPermalink", "earrings")
                .append("productTitle", "Earrings")
                .append("productPrice", "3000.00")
                .append("productDescription", "<p>Aros de oro</p>")
                .append("productGtin", "777888")
                .append("productBrand", "Goldsmith")
                .append("productPublished", true)
                .append("productTags", "accessories")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T08:30:00.000Z")
                .append("productStock", 30)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product18 = new Document("_id", "45678902abc")
                .append("productPermalink", "necklace")
                .append("productTitle", "Necklace")
                .append("productPrice", "4000.00")
                .append("productDescription", "<p>Collar de oro</p>")
                .append("productGtin", "111000")
                .append("productBrand", "GoldenStyle")
                .append("productPublished", true)
                .append("productTags", "accessories")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T08:45:00.000Z")
                .append("productStock", 15)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product19 = new Document("_id", "56789013abc")
                .append("productPermalink", "perfume")
                .append("productTitle", "Perfume")
                .append("productPrice", "2800.00")
                .append("productDescription", "<p>Aroma floral duradero</p>")
                .append("productGtin", "222333")
                .append("productBrand", "FragranceCo")
                .append("productPublished", true)
                .append("productTags", "beauty")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T09:00:00.000Z")
                .append("productStock", 60)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product20 = new Document("_id", "67890124abc")
                .append("productPermalink", "wallet")
                .append("productTitle", "Wallet")
                .append("productPrice", "700.00")
                .append("productDescription", "<p>Cartera de cuero</p>")
                .append("productGtin", "333555")
                .append("productBrand", "LeatherFinery")
                .append("productPublished", true)
                .append("productTags", "accessories")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T09:15:00.000Z")
                .append("productStock", 100)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product21 = new Document("_id", "90123456abc")
                .append("productPermalink", "headphones")
                .append("productTitle", "Headphones")
                .append("productPrice", "3200.00")
                .append("productDescription", "<p>Auriculares de alta calidad con cancelación de ruido</p>")
                .append("productGtin", "888888")
                .append("productBrand", "SoundMaster")
                .append("productPublished", true)
                .append("productTags", "electronics")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T07:45:00.000Z")
                .append("productStock", 45)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product22 = new Document("_id", "91234567abc")
                .append("productPermalink", "wallet")
                .append("productTitle", "Wallet")
                .append("productPrice", "1500.00")
                .append("productDescription", "<p>Cartera de cuero genuino con múltiples compartimientos</p>")
                .append("productGtin", "999999")
                .append("productBrand", "LeatherCraft")
                .append("productPublished", true)
                .append("productTags", "accessories")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T08:00:00.000Z")
                .append("productStock", 70)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product23 = new Document("_id", "92345678abc")
                .append("productPermalink", "tablet")
                .append("productTitle", "Tablet")
                .append("productPrice", "15000.00")
                .append("productDescription", "<p>Tablet con pantalla HD y 128GB de almacenamiento</p>")
                .append("productGtin", "101010")
                .append("productBrand", "TechWave")
                .append("productPublished", true)
                .append("productTags", "electronics")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T08:15:00.000Z")
                .append("productStock", 25)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product24 = new Document("_id", "93456789abc")
                .append("productPermalink", "water_bottle")
                .append("productTitle", "Water Bottle")
                .append("productPrice", "350.00")
                .append("productDescription", "<p>Botella de agua reutilizable de acero inoxidable</p>")
                .append("productGtin", "121212")
                .append("productBrand", "EcoGear")
                .append("productPublished", true)
                .append("productTags", "outdoor")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T08:30:00.000Z")
                .append("productStock", 150)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product25 = new Document("_id", "94567890abc")
                .append("productPermalink", "flashlight")
                .append("productTitle", "Flashlight")
                .append("productPrice", "800.00")
                .append("productDescription", "<p>Linterna LED de alto rendimiento</p>")
                .append("productGtin", "131313")
                .append("productBrand", "BrightLite")
                .append("productPublished", true)
                .append("productTags", "outdoor")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T08:45:00.000Z")
                .append("productStock", 85)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product26 = new Document("_id", "95678901abc")
                .append("productPermalink", "smartwatch")
                .append("productTitle", "Smartwatch")
                .append("productPrice", "8000.00")
                .append("productDescription", "<p>Reloj inteligente con monitor de frecuencia cardíaca</p>")
                .append("productGtin", "141414")
                .append("productBrand", "WearTech")
                .append("productPublished", true)
                .append("productTags", "electronics")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T09:00:00.000Z")
                .append("productStock", 40)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        // Productos del 27 al 30
        Document product27 = new Document("_id", "22334455abc")
                .append("productPermalink", "wireless_headphones")
                .append("productTitle", "Wireless Headphones")
                .append("productPrice", "2800.00")
                .append("productDescription", "<p>Auriculares inalámbricos con cancelación de ruido</p>")
                .append("productGtin", "121314")
                .append("productBrand", "SoundWave")
                .append("productPublished", true)
                .append("productTags", "electronics")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T08:45:00.000Z")
                .append("productStock", 30)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product28 = new Document("_id", "33445566abc")
                .append("productPermalink", "smart_watch")
                .append("productTitle", "Smart Watch")
                .append("productPrice", "5000.00")
                .append("productDescription", "<p>Reloj inteligente con seguimiento de salud</p>")
                .append("productGtin", "151617")
                .append("productBrand", "FitTrack")
                .append("productPublished", true)
                .append("productTags", "electronics")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T09:00:00.000Z")
                .append("productStock", 20)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product29 = new Document("_id", "44556677abc")
                .append("productPermalink", "gaming_laptop")
                .append("productTitle", "Gaming Laptop")
                .append("productPrice", "150000.00")
                .append("productDescription", "<p>Portátil para juegos de alto rendimiento</p>")
                .append("productGtin", "181920")
                .append("productBrand", "GameStation")
                .append("productPublished", true)
                .append("productTags", "electronics")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T09:15:00.000Z")
                .append("productStock", 15)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        Document product30 = new Document("_id", "55667788abc")
                .append("productPermalink", "4k_tv")
                .append("productTitle", "4K Ultra HD TV")
                .append("productPrice", "100000.00")
                .append("productDescription", "<p>Televisor 4K con HDR y Smart TV</p>")
                .append("productGtin", "212223")
                .append("productBrand", "VisionTech")
                .append("productPublished", true)
                .append("productTags", "electronics")
                .append("productComment", true)
                .append("productAddedDate", "2024-10-31T09:30:00.000Z")
                .append("productStock", 10)
                .append("productStockDisable", false)
                .append("productSubscription", null);

        // Insertar productos
        collection.insertMany(List.of(product1, product2, product3, product4, product5, product6, product7, product8, product9, product10,product11,product12,
                product13,product14,product15,product16,product17,product18,product19,product20,product21,product22,product23,product24,product25,product26
                ,product27,product28,product29,product30));
    }

    public void clearProducts() {
        MongoCollection<Document> collection = database.getCollection("products");

        // Eliminar los productos agregados en `seedProducts`
        collection.deleteMany(in("productPermalink", "shoes", "bag", "jacket", "hat", "watch", "belt", "socks", "gloves", "scarf", "sunglasses","sunglassesRosse","boots", "tshirt", "jeans", "sweater", "dress",
                "shorts", "skirt", "backpack", "ring", "headphones", "wallet", "tablet","sneakers","earrings","blouse","perfume","necklace",
                "water_bottle", "flashlight", "smartwatch", "wireless_headphones", "smart_watch", "gaming_laptop", "4k_tv"));
    }
}


