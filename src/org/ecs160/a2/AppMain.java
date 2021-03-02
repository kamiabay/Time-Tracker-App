package org.ecs160.a2;

import static com.codename1.ui.CN.*;
import com.codename1.io.Log;
import com.codename1.ui.*;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.layouts.*;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UITimer;
import java.io.IOException;

import com.codename1.io.NetworkEvent;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class AppMain {
    UI UIManager = new UI();

    public void init(Object context) {
        UIManager.initUI();
    }
    
    public void start() {
        UIManager.startUI();
    }



    public void stop() {
        UIManager.stopUI();
    }
    
    public void destroy() {
    }

}
