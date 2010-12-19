package cc.kune.core.client;

import cc.kune.core.client.cookies.CookiesManager;
import cc.kune.core.client.notify.SpinerPresenter;
import cc.kune.core.client.notify.UserNotifierPresenter;
import cc.kune.core.client.sitebar.logo.SiteLogoPresenter;
import cc.kune.core.client.ws.CorePresenter;

import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.gwtplatform.mvp.client.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyFailureHandler;

@GinModules({ CoreGinModule.class })
public interface CoreGinjector extends Ginjector {

    AsyncProvider<CorePresenter> getCorePresenter();

    AsyncProvider<CookiesManager> getCookiesManager();

    EventBus getEventBus();

    PlaceManager getPlaceManager();

    ProxyFailureHandler getProxyFailureHandler();

    AsyncProvider<SpinerPresenter> getSpinerPresenter();

    AsyncProvider<SiteLogoPresenter> getSiteLogoPresenter();

    AsyncProvider<UserNotifierPresenter> getUserNotifierPresenter();

}