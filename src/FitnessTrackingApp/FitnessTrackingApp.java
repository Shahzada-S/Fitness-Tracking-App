package FitnessTrackingApp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class FitnessTrackingApp extends Application {

    private Stage primaryStage;
    private int logoClickCount = 0;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Fitness Tracking App");

        showHomePage();
    }

    private void showHomePage() {
        Label logo = new Label("Fitness Tracking App");
        logo.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginEnthusiastBtn = new Button("Login as Enthusiast");
        loginEnthusiastBtn.setOnAction(e -> {
            String username = usernameField.getText();
            showEnthusiastPage(username);
        });

        Button loginTrainerBtn = new Button("Login as Trainer");
        loginTrainerBtn.setOnAction(e -> {
            String username = usernameField.getText();
            showTrainerPage(username);
        });

        Button createAccountBtn = new Button("Create Account");
        createAccountBtn.setOnAction(e -> showCreateAccountPage());

        Hyperlink forgotPasswordLink = new Hyperlink("Forgot Password?");
        forgotPasswordLink.setOnAction(e -> showForgotPasswordPage());

        Button adminLoginBtn = new Button("Admin Login");
        adminLoginBtn.setOnAction(e -> {
            String username = usernameField.getText();
            showAdminPage(username);
        });

        // Layout
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        HBox loginButtons = new HBox(10, loginEnthusiastBtn, loginTrainerBtn);
        loginButtons.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(
                logo, usernameField, passwordField, loginButtons,
                createAccountBtn, forgotPasswordLink, adminLoginBtn
        );


        logo.setOnMouseClicked(event -> {
            logoClickCount++;
            if (logoClickCount == 3) {
                adminLoginBtn.setVisible(true);
                logoClickCount = 0;
            }
        });

        // Sets the scene size
        Scene scene = new Scene(layout, 600, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    // METHODS FOR EACH PAGE (still incomplete)
    private void showEnthusiastPage(String username) {

        Label greetingLabel = new Label("Hello, " + username + "!");
        greetingLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Button workoutHistoryBtn = new Button("Workout History & Progress");
        workoutHistoryBtn.setOnAction(e -> showWorkoutHistoryPage(username));

        Button workoutPlansBtn = new Button("Workout Plans");
        workoutPlansBtn.setOnAction(e -> showWorkoutPlansPage1(username));

        Button subscriptionsBtn = new Button("Subscriptions");
        subscriptionsBtn.setOnAction(e -> showSubscriptionsPage(username));

        Button profileMgmtBtn = new Button("Profile Management");
        profileMgmtBtn.setOnAction(e -> showProfileManagementUserPage(username));

        HBox row1 = new HBox(10, workoutHistoryBtn, workoutPlansBtn);
        HBox row2 = new HBox(10, subscriptionsBtn, profileMgmtBtn);

        row1.setAlignment(Pos.CENTER);
        row2.setAlignment(Pos.CENTER);

        StackPane backButton = createBackButton();
        backButton.setOnMouseClicked(e -> showHomePage());

        VBox layout = new VBox(20, backButton, greetingLabel, row1, row2);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene enthusiastScene = new Scene(layout, 600, 800);
        primaryStage.setScene(enthusiastScene);
    }


    private void showTrainerPage(String username) {

        Label greetingLabel = new Label("Hello, " + username + "!");
        greetingLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Button createPlanBtn = new Button("Create Workout Plan");
        createPlanBtn.setOnAction(e -> showCreateWorkoutPlanPage(username));

        Button updatePlanBtn = new Button("Update Workout Plan");
        updatePlanBtn.setOnAction(e -> showUpdateWorkoutPlanPage(username));

        Button userProgressBtn = new Button("User Progress");
        userProgressBtn.setOnAction(e -> showUserProgressPage(username));

        Button profileMgmtBtn = new Button("Profile Management");
        profileMgmtBtn.setOnAction(e -> showProfileManagementTrainerPage(username));

        HBox row1 = new HBox(10, createPlanBtn, updatePlanBtn);
        HBox row2 = new HBox(10, userProgressBtn, profileMgmtBtn);

        row1.setAlignment(Pos.CENTER);
        row2.setAlignment(Pos.CENTER);

        StackPane backButton = createBackButton();
        backButton.setOnMouseClicked(e -> showHomePage());

        VBox layout = new VBox(20, backButton, greetingLabel, row1, row2);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene trainerScene = new Scene(layout, 600, 800);
        primaryStage.setScene(trainerScene);
    }

    private void showAdminPage(String username) {

        Label greetingLabel = new Label("Welcome Admin, " + username + "!");
        greetingLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Button manageUsersBtn = new Button("Manage Users");
        manageUsersBtn.setOnAction(e -> showManageUsersPage(username));

        Button managePlansBtn = new Button("Manage Workout Plans & Subscriptions");
        managePlansBtn.setOnAction(e -> showManagePlansAndSubscriptionsPage(username));

        Button performanceBtn = new Button("User Progress & Trainer Performance");
        performanceBtn.setOnAction(e -> showUserProgressAndTrainerPerformancePage(username));

        Button reportsBtn = new Button("Generate Reports");
        reportsBtn.setOnAction(e -> showGenerateReportsPage(username));

        HBox row1 = new HBox(10, manageUsersBtn, managePlansBtn);
        HBox row2 = new HBox(10, performanceBtn, reportsBtn);

        row1.setAlignment(Pos.CENTER);
        row2.setAlignment(Pos.CENTER);

        StackPane backButton = createBackButton();
        backButton.setOnMouseClicked(e -> showHomePage());

        VBox layout = new VBox(20, backButton, greetingLabel, row1, row2);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene adminScene = new Scene(layout, 600, 800);
        primaryStage.setScene(adminScene);
    }

    private void showCreateAccountPage() {
        VBox createAccountLayout = createPage("Create Account Page");
        Scene createAccountScene = new Scene(createAccountLayout, 600, 800);
        primaryStage.setScene(createAccountScene);
    }

    private void showForgotPasswordPage() {
        VBox forgotPasswordLayout = createPage("Forgot Password Page");
        Scene forgotPasswordScene = new Scene(forgotPasswordLayout, 600, 800);
        primaryStage.setScene(forgotPasswordScene);
    }
    // FITNESS ENTHUSIAST PAGES
    private void showWorkoutHistoryPage(String username) {
        Label greeting = new Label("Hello, " + username + "!");
        greeting.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label title = new Label("Workout History & Progress");
        title.setStyle("-fx-font-size: 16px;");

        StackPane backButton = createBackButton();
        backButton.setOnMouseClicked(e -> showEnthusiastPage(username));

        VBox workoutHistoryLayout = new VBox(20, backButton, greeting, title);
        workoutHistoryLayout.setAlignment(Pos.CENTER);
        workoutHistoryLayout.setPadding(new Insets(20));

        Scene workoutHistoryScene = new Scene(workoutHistoryLayout, 600, 800);
        primaryStage.setScene(workoutHistoryScene);
    }

    private void showWorkoutPlansPage1(String username) {
        Label greeting = new Label("Hello, " + username + "!");
        greeting.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label title = new Label("Workout Plans");
        title.setStyle("-fx-font-size: 16px;");

        StackPane backButton = createBackButton();
        backButton.setOnMouseClicked(e -> showEnthusiastPage(username));

        VBox workoutPlansLayout1 = new VBox(20, backButton, greeting, title);
        workoutPlansLayout1.setAlignment(Pos.CENTER);
        workoutPlansLayout1.setPadding(new Insets(20));

        Scene workoutPlansScene1 = new Scene(workoutPlansLayout1, 600, 800);
        primaryStage.setScene(workoutPlansScene1);
    }

    private void showWorkoutPlansPage2() {
        VBox workoutPlansLayout2 = createPage("Workout Plans");
        Scene workoutPlansScene2 = new Scene(workoutPlansLayout2, 600, 800);
        primaryStage.setScene(workoutPlansScene2);
    }

    private void showSubscriptionsPage(String username) {
        Label greeting = new Label("Hello, " + username + "!");
        greeting.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label title = new Label("Subscriptions");
        title.setStyle("-fx-font-size: 16px;");

        StackPane backButton = createBackButton();
        backButton.setOnMouseClicked(e -> showEnthusiastPage(username));

        VBox SubscriptionsLayout = new VBox(20, backButton, greeting, title);
        SubscriptionsLayout.setAlignment(Pos.CENTER);
        SubscriptionsLayout.setPadding(new Insets(20));

        Scene SubscriptionsScene = new Scene(SubscriptionsLayout, 600, 800);
        primaryStage.setScene(SubscriptionsScene);
    }

    private void showProfileManagementUserPage(String username) {
        Label greeting = new Label("Hello, " + username + "!");
        greeting.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label title = new Label("Profile Management");
        title.setStyle("-fx-font-size: 16px;");

        StackPane backButton = createBackButton();
        backButton.setOnMouseClicked(e -> showEnthusiastPage(username));

        HBox nameRow = new HBox(10, new Label("Name:"), new TextField());
        HBox ageRow = new HBox(10, new Label("Age:"), new TextField());
        HBox genderRow = new HBox(10, new Label("Gender:"), new TextField());
        HBox heightRow = new HBox(10, new Label("Height:"), new TextField());
        HBox weightRow = new HBox(10, new Label("Weight:"), new TextField());
        HBox goalRow = new HBox(10, new Label("Fitness Goal:"), new TextField());
        HBox passwordRow = new HBox(10, new Label("New Password:"), new TextField());

        nameRow.setAlignment(Pos.CENTER);
        ageRow.setAlignment(Pos.CENTER);
        genderRow.setAlignment(Pos.CENTER);
        heightRow.setAlignment(Pos.CENTER);
        weightRow.setAlignment(Pos.CENTER);
        goalRow.setAlignment(Pos.CENTER);
        passwordRow.setAlignment(Pos.CENTER);

        VBox form = new VBox(10, nameRow, ageRow, genderRow, heightRow, weightRow, goalRow, passwordRow);
        form.setAlignment(Pos.CENTER);

        Button updateBtn = new Button("Update");
        Button logoutBtn = new Button("Log Out");
        logoutBtn.setOnAction(e -> showHomePage());

        VBox ProfileManagementUserLayout = new VBox(20, backButton, greeting, title, form, updateBtn, logoutBtn);
        ProfileManagementUserLayout.setAlignment(Pos.CENTER);
        ProfileManagementUserLayout.setPadding(new Insets(20));

        Scene ProfileManagementUserScene = new Scene(ProfileManagementUserLayout, 600, 800);
        primaryStage.setScene(ProfileManagementUserScene);
    }

    // FITNESS TRAINER PAGES
    private void showCreateWorkoutPlanPage(String username) {
        Label greeting = new Label("Hello, " + username + "!");
        greeting.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label title = new Label("Create Workout Plan");
        title.setStyle("-fx-font-size: 16px;");

        StackPane backButton = createBackButton();
        backButton.setOnMouseClicked(e -> showTrainerPage(username));

        VBox CreateWorkoutPlanLayout = new VBox(20, backButton, greeting, title);
        CreateWorkoutPlanLayout.setAlignment(Pos.CENTER);
        CreateWorkoutPlanLayout.setPadding(new Insets(20));

        Scene CreateWorkoutPlanScene = new Scene(CreateWorkoutPlanLayout, 600, 800);
        primaryStage.setScene(CreateWorkoutPlanScene);
    }

    private void showUserProgressPage(String username) {
        Label greeting = new Label("Hello, " + username + "!");
        greeting.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label title = new Label("User Progress");
        title.setStyle("-fx-font-size: 16px;");

        StackPane backButton = createBackButton();
        backButton.setOnMouseClicked(e -> showTrainerPage(username));

        VBox UserProgressLayout = new VBox(20, backButton, greeting, title);
        UserProgressLayout.setAlignment(Pos.CENTER);
        UserProgressLayout.setPadding(new Insets(20));

        Scene UserProgressScene = new Scene(UserProgressLayout, 600, 800);
        primaryStage.setScene(UserProgressScene);
    }

    private void showUpdateWorkoutPlanPage(String username) {
        Label greeting = new Label("Hello, " + username + "!");
        greeting.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label title = new Label("Update Workout Plan");
        title.setStyle("-fx-font-size: 16px;");

        StackPane backButton = createBackButton();
        backButton.setOnMouseClicked(e -> showTrainerPage(username));

        VBox updateWorkoutPlanLayout = new VBox(20, backButton, greeting, title);
        updateWorkoutPlanLayout.setAlignment(Pos.CENTER);
        updateWorkoutPlanLayout.setPadding(new Insets(20));

        Scene UserProgressScene = new Scene(updateWorkoutPlanLayout, 600, 800);
        primaryStage.setScene(UserProgressScene);
    }

    private void showProfileManagementTrainerPage(String username) {
        Label greeting = new Label("Hello, " + username + "!");
        greeting.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label title = new Label("Profile Management");
        title.setStyle("-fx-font-size: 16px;");

        StackPane backButton = createBackButton();
        backButton.setOnMouseClicked(e -> showTrainerPage(username));

        HBox passwordRow = new HBox(10, new Label("New Password:"), new TextField());
        passwordRow.setAlignment(Pos.CENTER);

        Button updateBtn = new Button("Update");
        Button logoutBtn = new Button("Log Out");
        logoutBtn.setOnAction(e -> showHomePage());

        VBox ProfileManagementTrainerLayout = new VBox(20, backButton, greeting, title, passwordRow, updateBtn, logoutBtn);
        ProfileManagementTrainerLayout.setAlignment(Pos.CENTER);
        ProfileManagementTrainerLayout.setPadding(new Insets(20));

        Scene ProfileManagementTrainerScene = new Scene(ProfileManagementTrainerLayout, 600, 800);
        primaryStage.setScene(ProfileManagementTrainerScene);
    }

    // ADMIN PAGES
    private void showManageUsersPage(String username) {
        Label greeting = new Label("Welcome Admin, " + username + "!");
        greeting.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label title = new Label("Manage Users");
        title.setStyle("-fx-font-size: 16px;");

        Button fitnessTrainersBtn = new Button("Fitness Trainers");
        Button fitnessEnthusiastsBtn = new Button("Fitness Enthusiasts");
        Button logoutBtn = new Button("Log Out");
        logoutBtn.setOnAction(e -> showHomePage());

        StackPane backButton = createBackButton();
        backButton.setOnMouseClicked(e -> showAdminPage(username));

        VBox layout = new VBox(20, backButton, greeting, title, fitnessTrainersBtn, fitnessEnthusiastsBtn, logoutBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene ManageUsersScene = new Scene(layout, 600, 800);
        primaryStage.setScene(ManageUsersScene);
    }

    private void showUserProgressAndTrainerPerformancePage(String username) {
        Label greeting = new Label("Welcome Admin, " + username + "!");
        greeting.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label title = new Label("User Progress & Trainer Performance");
        title.setStyle("-fx-font-size: 16px;");

        Button userProgressBtn = new Button("User Progress");
        Button trainerPerformanceBtn = new Button("Trainer Performance");

        StackPane backButton = createBackButton();
        backButton.setOnMouseClicked(e -> showAdminPage(username));;

        VBox layout = new VBox(20, backButton, greeting, title, userProgressBtn, trainerPerformanceBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene UserProgressAndTrainerPerformanceScene = new Scene(layout, 600, 800);
        primaryStage.setScene(UserProgressAndTrainerPerformanceScene);
    }

    private void showManagePlansAndSubscriptionsPage(String username) {
        Label greeting = new Label("Welcome Admin, " + username + "!");
        greeting.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label title = new Label("Manage Workout Plan & Subscriptions");
        title.setStyle("-fx-font-size: 16px;");

        Button managePlansBtn = new Button("Manage Workout Plans");
        Button subscriptionsBtn = new Button("Subscriptions");

        StackPane backButton = createBackButton();
        backButton.setOnMouseClicked(e -> showAdminPage(username));

        VBox layout = new VBox(20, backButton, greeting, title, managePlansBtn, subscriptionsBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene ManagePlansAndSubscriptionsScene = new Scene(layout, 600, 800);
        primaryStage.setScene(ManagePlansAndSubscriptionsScene);
    }

    private void showGenerateReportsPage(String username) {
        Label greeting = new Label("Welcome Admin, " + username + "!");
        greeting.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label title = new Label("Generate Reports");
        title.setStyle("-fx-font-size: 16px;");

        HBox enthusiastsRow = new HBox(10, new Label("Enthusiasts enrolled"), new Button("Generate"));
        enthusiastsRow.setAlignment(Pos.CENTER);

        HBox trainersRow = new HBox(10, new Label("Trainers enrolled"), new Button("Generate"));
        trainersRow.setAlignment(Pos.CENTER);

        StackPane backButton = createBackButton();
        backButton.setOnMouseClicked(e -> showAdminPage(username));

        VBox layout = new VBox(20, backButton, greeting, title, enthusiastsRow, trainersRow);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene GenerateReportsScene = new Scene(layout, 600, 800);
        primaryStage.setScene(GenerateReportsScene);
    }

    // Helper method to create pages with a back button
    private VBox createPage(String pageTitle) {

        StackPane backButton = createBackButton();
        backButton.setOnMouseClicked(e -> showHomePage());

        // Page title
        Label pageLabel = new Label(pageTitle);
        pageLabel.setStyle("-fx-font-size: 20px;");

        // Layout for the page
        VBox pageLayout = new VBox(10, backButton, pageLabel);
        pageLayout.setAlignment(Pos.CENTER);
        pageLayout.setPadding(new Insets(20));

        return pageLayout;
    }

    // Method to create the back button with a triangle icon
    private StackPane createBackButton() {
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(
                0.0, 20.0,
                20.0, 0.0,
                20.0, 40.0
        );
        triangle.setFill(Color.BLUE);

        // Create a StackPane to hold the triangle and handle events
        StackPane backButton = new StackPane(triangle);
        backButton.setPadding(new Insets(10));
        backButton.setAlignment(Pos.TOP_LEFT);

        return backButton;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
