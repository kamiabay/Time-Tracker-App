package org.ecs160.a2.UI_PAGES;

import com.codename1.io.Log;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;
import com.codename1.components.MultiButton;
import com.codename1.ui.events.ActionEvent;
import org.ecs160.a2.Storage.Store;
import org.ecs160.a2.model.Task;

import java.util.Arrays;
import java.util.List;

import static com.codename1.ui.CN.*;

public class MainPageUI
{
    Store store = new Store();
    Form skeleton;
    private Resources theme;
    private Form current;
    public static MainPageUI mainPage = new MainPageUI();

    public void initUI(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });
    }

    public void loadMainPageUI() {
        if(current != null){
            current.show();
            return;
        }

        MultiButton[] listOfTasks = {}; //Array of Buttons. Buttons will be task names here. Need to access database.
        skeleton = new Form("Task List", new BorderLayout());
        Command createTask = new Command("Create Task") {
            public void actionPerformed(ActionEvent e) {
                CreateTaskPageUI.createTaskPage.startUI();
            }
        };

        skeleton.getToolbar().addCommandToRightBar(createTask);

        Container list = new Container(BoxLayout.y());
        list.setScrollableY(true);
        skeleton.add(CENTER, list);
        List<Task> taskList = store.getAllTasks();

        listOfTasks = Arrays.copyOf(listOfTasks, listOfTasks.length + taskList.size()); // this line will not be needed once we have the database
        /*
        listOfTasks[listOfTasks.length - 7] = new MultiButton("Bug Check Again and Again");
        listOfTasks[listOfTasks.length - 6] = new MultiButton("Bug Check Again");
        listOfTasks[listOfTasks.length - 5] = new MultiButton("Bug Check");
        listOfTasks[listOfTasks.length - 4] = new MultiButton("Studying");
        listOfTasks[listOfTasks.length - 3] = new MultiButton("Testing");
        listOfTasks[listOfTasks.length - 2] = new MultiButton("Practicing");
        listOfTasks[listOfTasks.length - 1] = new MultiButton("Running"); */

        for (int j = 0; j < listOfTasks.length; ++j) {
<<<<<<< HEAD
            String taskName = "Container " + j;
            listOfTasks[j] = new Container(BoxLayout.x());
            listOfTasks[j].setWidth(skeleton.getWidth());
            listOfTasks[j].setY(skeleton.getHeight());

            MultiButton taskButton = new MultiButton(taskName);
            taskButton.addActionListener((e)->editBtnPressed(taskName));
            taskButton.setWidth(skeleton.getWidth());

            listOfTasks[j].addComponent(taskButton);
            list.addComponent(0,listOfTasks[j]);
            //listOfTasks[j].getAllStyles().setBgColor(14737632);
=======
            listOfTasks[j] = new MultiButton("Bug Testing " + j);
            list.addComponent(0,listOfTasks[j]);
            //listOfTasks[j].getAllStyles().setBgColor(14737632);
            listOfTasks[j].setWidth(skeleton.getWidth());
            listOfTasks[j].setY(skeleton.getHeight());
            String taskName = listOfTasks[j].getText();
            listOfTasks[j].addActionListener((e) -> editBtnPressed(taskName));
>>>>>>> bc630a02acec9f669af5817e0ee45e84572c6786
        }

        // Below is intended for the future when listOfTasks is compatible with the database of tasks.
        /* for (int i = 0; i < listOfTasks.length; ++i) {
            listOfTasks.getAllStyles().setFgColor(112);
            skeleton.add(listOfTasks[i]);
        } */


        skeleton.show();
    }

    public void editBtnPressed(String taskName) {
        // We'll use the taskName to ID which task we'll be editing.
        EditPageUI.editPage.loadEditPageUI(taskName);
    }

    public void stopUI() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }

    public void destroyUI() {

    }
}
