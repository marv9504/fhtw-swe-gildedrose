# Gilded Rose Rebuild

## Project Description

This project is a redevelopment of the **Gilded Rose** inventory management system. The primary goals are to provide a high-quality, extensible design and an implementation that supports complex logic for managing product quality and pricing over time. A new pricing component has been added to facilitate international expansion, allowing products to be priced and calculated in multiple currencies.

## Requirements

The new solution was developed with the following key requirements in mind:

- **Extendability**: The system is designed to easily support new product types without extensive rework.
- **Reusable Quality and Pricing Logic**: Mechanisms for adjusting product quality and price changes are implemented as strategies, allowing them to be applied flexibly across multiple products.
- **Comprehensive Cart and Pricing Features**: The solution includes a shopping cart that supports:
  - Displaying individual product prices
  - Calculating the total cart price
  - Supporting bulk discounts and currency conversion
- **Internationalization**: Prices are calculable in multiple currencies to support international markets.

## Features and Implementation

### 1. **Quality Management Strategies**

The solution uses a **Strategy Pattern** to handle various types of products with specific quality management rules:

- **DefaultQualityStrategy**: Decreases quality over time and accelerates the decrease after the sell-by date.
- **DeadlineQualityStrategy**: Quality increases as the product’s sell-by date approaches but drops to zero afterward.
- **IncreasingQualityStrategy**: For products that improve in quality over time (e.g., aged items), with quality increasing faster after the sell-by date.
- **ConjuredQualityStrategy**: Quality decreases twice as fast as standard items.
- **LegendaryQualityStrategy**: Legendary items do not change in quality or sell-in values.

These strategies ensure that each product’s quality evolves according to its type, making it straightforward to add new types with unique rules.

### 2. **Pricing and Currency Conversion**

- **Pricing Strategy Pattern**: Pricing strategies are used to manage different pricing rules for products. For example:
  - **DefaultPricingStrategy**: Calculates a simple price based on product quantity.
  - **BulkDiscountStrategy**: Applies a discount when purchasing items in bulk.
- **Currency Conversion**: A `CurrencyConverter` class is included to support pricing calculations in various currencies, enhancing the system's suitability for international expansion.

### 3. **Shopping Cart**

The `ShoppingCart` class is central to managing products and their prices. Key features include:
- **Adding/Removing Products**: Items can be added to or removed from the cart.
- **Total Price Calculation**: Calculates the total price for all items in the cart, applying the current pricing strategy and currency conversion as needed.
- **Discount Application**: Supports applying bulk discounts where applicable, allowing flexible promotion management.

## Structure and Design

The project is structured into several packages to ensure separation of concerns:

- **`com.fhtw.core`**: Core classes like `Item`, which represents a product with attributes like name, quality, sell-in, price, and quantity.
- **`com.fhtw.quality`**: Implements quality strategies using the `QualityStrategy` interface.
- **`com.fhtw.pricing`**: Implements pricing strategies with a focus on supporting flexible pricing rules for items in the cart.
- **`com.fhtw.cart`**: Manages shopping cart functionality, integrating quality and pricing strategies.

## Testing

The project includes comprehensive unit tests to validate each component:

- **Quality Strategy Tests**: Each quality strategy is tested before, on, and after the sell-by date to verify correct adjustments to quality.
- **Pricing Strategy Tests**: Tests validate pricing calculations, including bulk discounts and adherence to pricing limits.
- **Shopping Cart and Conversion Tests**: The shopping cart’s ability to calculate totals, apply discounts, and convert prices across currencies is thoroughly tested.

## Running the Project

### Prerequisites

- **Java**: Ensure Java is installed and configured on your system.
- **JUnit**: Tests are written using JUnit.

### Execution

1. **Compile the Project**:
   ```bash
   javac -d bin src/com/fhtw/**/*.java
   ```

2. **Run Tests**: Run JUnit tests to ensure that all components work as expected.
   ```bash
   java -cp bin:libs/junit-5.7.0.jar:libs/hamcrest-core-1.3.jar org.junit.runner.JUnitCore
   ```

3. **Run `TestMain`**:
   ```bash
   java -cp bin com.fhtw.TestMain
   ```

   This will output sample results for each strategy, demonstrating item quality and price changes over time.

## Deliverables

- **Core Domain Chart**: Visualizes sub-domains, including Quality, Pricing, and Cart Management.
- **Solution Design Diagram**: Shows how classes interact, including package structures and the relationships between strategies.
- **Management Summary**: A slide summarizing the solution’s benefits, including scalability, internationalization support, and the ease of adding new product types.

## Summary of Benefits

This solution improves the **Gilded Rose** system with:

- **Modularity**: A well-organized structure using patterns such as Strategy and Factory, making it easy to maintain and extend.
- **International Support**: Pricing and currency features enable global expansion.
- **Flexibility**: Easily customizable strategies allow for varied quality and pricing rules to be applied across product types.
