package ConnectHub;
import java.util.Timer;
import java.util.TimerTask;
public class StoryCleanupScheduler {
    private Timer timer;
    private ContentManager contentManager;

    public StoryCleanupScheduler(ContentManager contentManager) {
        this.contentManager = contentManager;
        timer = new Timer(true); // Daemon thread
    }

    public void startCleanupTask() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                contentManager.removeExpiredStories();
            }
        }, 0, 3600000); // Run every 1 hour
    }
}
    