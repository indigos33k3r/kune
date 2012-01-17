package cc.kune.core.client.sitebar.auth;

import cc.kune.common.client.notify.NotifyLevel;
import cc.kune.common.client.notify.NotifyLevelImages;
import cc.kune.common.client.notify.NotifyUser;
import cc.kune.common.client.ui.MaskWidgetView;
import cc.kune.common.client.ui.dialogs.MessageToolbar;
import cc.kune.common.shared.i18n.I18nTranslationService;
import cc.kune.core.client.auth.SignInAbstractPanel;
import cc.kune.core.client.auth.UserFieldFactory;
import cc.kune.core.client.errors.EmailNotFoundException;
import cc.kune.core.client.events.StackErrorEvent;
import cc.kune.core.client.rpcservices.UserServiceAsync;
import cc.kune.core.client.state.Session;
import cc.kune.core.client.ui.DefaultForm;

import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class AskForPasswordResetPanel extends SignInAbstractPanel {

  public static final String ASK_PASSWD_RESET_DIALOG = "k-ask-for-pwd-diag";
  public static final String CANCEL_BUTTON_ID = "k-ask-for-pwd-cancel";
  public static final String EMAIL_RESET_ID = "k-ask-for-pwd-email";
  public static final String ERRMSG = "k-ask-for-pwd-error";
  public static final String RESET_BUTTON_ID = "k-ask-for-pwd-reset";
  private final TextField<String> resetEmail;

  @Inject
  public AskForPasswordResetPanel(final I18nTranslationService i18n, final Session session,
      final MaskWidgetView mask, final NotifyLevelImages images, final EventBus eventbus,
      final UserFieldFactory userFieldFactory, final Provider<UserServiceAsync> userService) {
    super(ASK_PASSWD_RESET_DIALOG, mask, i18n, i18n.t("Reset your password"), true, true, true, "",
        i18n.t("Reset your password"), RESET_BUTTON_ID, i18n.tWithNT("Cancel", "used in button"),
        CANCEL_BUTTON_ID, images, ERRMSG, 1);
    final DefaultForm form = new DefaultForm();
    final LabelField desc = new LabelField(
        i18n.t("Please enter your email address. You will receive a link to create a new password via email."));
    form.add(desc);
    resetEmail = userFieldFactory.createUserEmail(EMAIL_RESET_ID);
    resetEmail.setFieldLabel(i18n.t("email"));
    resetEmail.setTabIndex(1);
    messageErrorBar = new MessageToolbar(images, errorLabelId);
    form.add(resetEmail);
    form.add(messageErrorBar);
    super.getFirstBtn().addClickHandler(new ClickHandler() {
      @Override
      public void onClick(final ClickEvent event) {
        if (form.isValid()) {
          userService.get().askForPasswordReset(resetEmail.getValue(), new AsyncCallback<Void>() {
            @Override
            public void onFailure(final Throwable caught) {
              if (caught instanceof EmailNotFoundException) {
                AskForPasswordResetPanel.this.setErrorMessage(i18n.t("Invalid email"), NotifyLevel.error);
              } else {
                AskForPasswordResetPanel.this.setErrorMessage(
                    i18n.t("Other error trying to reset your password"), NotifyLevel.error);
              }
              StackErrorEvent.fire(eventbus, caught);
              AskForPasswordResetPanel.this.messageErrorBar.setVisible(true);
            }

            @Override
            public void onSuccess(final Void result) {
              NotifyUser.info(i18n.t("Check your email for the confirmation link"));
              hide();
            }
          });
        }
      }
    });
    super.getInnerPanel().add(form.getFormPanel());
    super.getSecondBtn().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(final ClickEvent event) {
        hide();
      }
    });
  }

  @Override
  public void hide() {
    super.hide();
    super.messageErrorBar.hideErrorMessage();
    resetEmail.clear();
  }

  @Override
  public void show() {
    super.show();
  }
}
