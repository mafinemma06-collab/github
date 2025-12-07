package Erin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SMMDashboardController {

    private SocialMediaManager currentUser;
    private ObservableList<SocialMediaPost> allPosts;


    @FXML private Label welcomeLabel;
    @FXML private TableView<SocialMediaPost> postsTable;
    @FXML private TableColumn<SocialMediaPost, String> platformCol;
    @FXML private TableColumn<SocialMediaPost, String> dateCol;
    @FXML private TableColumn<SocialMediaPost, Integer> engagementCol;

    @FXML private TextArea contentArea;
    @FXML private ComboBox<String> platformCombo;
    @FXML private Label postMessageLabel;

    @FXML private BarChart<String, Number> analyticsChart;


    public void initialize() {

        platformCombo.setItems(FXCollections.observableArrayList("Facebook", "Twitter", "Instagram"));
        setupPostsTable();
    }

    public void initData(SocialMediaManager user) {
        this.currentUser = user;
        welcomeLabel.setText("Welcome, Social Media Manager (" + currentUser.getUsername() + ")");
        loadAllPosts();
        postsTable.setItems(allPosts);


        updateAnalyticsChart();
    }


    private void loadAllPosts() {

        List<SocialMediaPost> fetchedPosts = FileManager.loadPosts();
        allPosts = FXCollections.observableArrayList(fetchedPosts);


        allPosts.forEach(post -> {
            if(post.getLikes() == 0 && post.getShares() == 0 && post.getComments() == 0) {
                post.setLikes((int) (Math.random() * 50));
                post.setShares((int) (Math.random() * 20));
                post.setComments((int) (Math.random() * 10));
            }
        });
        FileManager.savePosts(allPosts);
    }

    private void setupPostsTable() {

        platformCol.setCellValueFactory(new PropertyValueFactory<>("platform"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("postDate"));

        engagementCol.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getTotalEngagement()).asObject());
    }


    @FXML
    private void onCreateNewPost() {
        String content = contentArea.getText();
        String platform = platformCombo.getValue();

        if (content.length() < 10 || platform == null) {
            postMessageLabel.setText("Validation Failed: Content too short or platform not selected.");
            return;
        }

        SocialMediaPost newPost = new SocialMediaPost(content, platform);
        newPost.setLikes(1);
        newPost.setShares(1);
        newPost.setComments(1);

        allPosts.add(newPost);
        FileManager.savePosts(allPosts);

        postMessageLabel.setText("Post published to " + platform + " successfully!");

        contentArea.clear();
        postsTable.refresh();
        updateAnalyticsChart();
    }


    @FXML
    private void onViewAnalytics() {
        updateAnalyticsChart();
    }

    private void updateAnalyticsChart() {
        analyticsChart.getData().clear();


        XYChart.Series<String, Number> engagementSeries = new XYChart.Series<>();
        engagementSeries.setName("Total Engagement");

        allPosts.stream()
                .collect(Collectors.groupingBy(SocialMediaPost::getPlatform,
                        Collectors.summingInt(SocialMediaPost::getTotalEngagement)))
                .forEach((platform, totalEngagement) -> {
                    engagementSeries.getData().add(new XYChart.Data<>(platform, totalEngagement));
                });

        analyticsChart.getData().add(engagementSeries);



    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}