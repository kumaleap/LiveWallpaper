package com.warpdrive.wallpaper.service;

import com.warpdrive.wallpaper.MyRenderer;

/**
 * Created by wulijie on 2018/1/26.
 * 测试实现OpenGl壁纸
 */
public class MyGLWallpaperService extends GLWallpaperService {
    public MyGLWallpaperService() {
        super();
    }

    public Engine onCreateEngine() {
        MyEngine engine = new MyEngine();
        return engine;
    }

    class MyEngine extends GLEngine {
        MyRenderer renderer;

        public MyEngine() {
            super();
            // handle prefs, other initialization
            renderer = new MyRenderer();
            setRenderer(renderer);
            setRenderMode(RENDERMODE_CONTINUOUSLY);
        }

        public void onDestroy() {
            super.onDestroy();
            if (renderer != null) {
                renderer.release();
            }
            renderer = null;
        }
    }
}
