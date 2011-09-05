/*
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * Adapter by Kune Dev Team
 */
package cc.kune.gspace.client.i18n;

import cc.kune.core.shared.dto.I18nLanguageSimpleDTO;
import cc.kune.core.shared.dto.I18nTranslationDTO;
import cc.kune.core.shared.i18n.I18nTranslationService;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.inject.Inject;

public class I18nCellList extends Composite {

  /**
   * The UiBinder interface used by this example.
   */
  interface Binder extends UiBinder<Widget, I18nCellList> {
  }

  /**
   * The Cell used to render a {@link I18nTranslationDTO}.
   */
  static class TranslationCell extends AbstractCell<I18nTranslationDTO> {
    private static String DIRTY_STYLE = "font-style: italic;";
    private static String ODD_STYLE = "";

    // private static String ODD_STYLE = "background-color: #F3F7FB;";

    public TranslationCell() {
    }

    @Override
    public boolean dependsOnSelection() {
      return super.dependsOnSelection();
    }

    @Override
    public void onBrowserEvent(final com.google.gwt.cell.client.Cell.Context context,
        final Element parent, final I18nTranslationDTO value, final NativeEvent event,
        final ValueUpdater<I18nTranslationDTO> valueUpdater) {
      super.onBrowserEvent(context, parent, value, event, valueUpdater);
    }

    @Override
    protected void onEnterKeyDown(final com.google.gwt.cell.client.Cell.Context context,
        final Element parent, final I18nTranslationDTO value, final NativeEvent event,
        final ValueUpdater<I18nTranslationDTO> valueUpdater) {

    }

    @Override
    public void render(final Context context, final I18nTranslationDTO value, final SafeHtmlBuilder sb) {
      // Value can be null, so do a null check..
      if (value == null) {
        return;
      }
      final int index = context.getIndex();
      final boolean odd = index % 2 == 0;
      sb.appendHtmlConstant("<div style='display: table-row; border-bottom: 1px dashed #CCC; "
          + (odd ? ODD_STYLE : "") + "'>");
      sb.appendHtmlConstant("<div style='display: table-cell; width: 100%; padding: 1px 5px;"
          + (value.isDirty() ? DIRTY_STYLE : "") + "'>");
      sb.appendEscaped(value.getTrKey());
      sb.appendHtmlConstant("</div></div>");
    }
  }

  /**
   * The CellList.
   */
  private final CellList<I18nTranslationDTO> cellList;

  private final I18nTranslationProvider data;

  /**
   * The pager used to change the range of data.
   */
  @UiField
  ShowMorePagerPanel pagerPanel;

  /**
   * The pager used to display the current range.
   */
  @UiField
  RangeLabelPager rangeLabelPager;

  /**
   * The form used to update translations
   */
  @UiField
  I18nTranslatorForm translatorForm;

  @Inject
  public I18nCellList(final I18nTranslationProvider data, final I18nTranslationService i18n) {
    this.data = data;
    final TranslationCell cell = new TranslationCell();

    // Set a key provider that provides a unique key for each contact. If key is
    // used to identify translations when fields change.
    cellList = new CellList<I18nTranslationDTO>(cell, I18nTranslationDTO.KEY_PROVIDER);
    cellList.setPageSize(30);
    cellList.setEmptyListMessage(SafeHtmlUtils.fromTrustedString("<span style='padding: 10px; font-style: italic;'>Loading</span>"));
    cellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
    cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);
    cellList.addHandler(new KeyPressHandler() {
      @Override
      public void onKeyPress(final KeyPressEvent event) {
        if (event.getNativeEvent().getKeyCode() == com.google.gwt.event.dom.client.KeyCodes.KEY_UP) {
        } else if (event.getNativeEvent().getKeyCode() == com.google.gwt.event.dom.client.KeyCodes.KEY_DOWN) {
        }
      }
    }, KeyPressEvent.getType());
    // Add a selection model so we can select cells.
    final SingleSelectionModel<I18nTranslationDTO> selectionModel = new SingleSelectionModel<I18nTranslationDTO>(
        I18nTranslationDTO.KEY_PROVIDER);
    cellList.setSelectionModel(selectionModel);
    cellList.setValueUpdater(new ValueUpdater<I18nTranslationDTO>() {
      @Override
      public void update(final I18nTranslationDTO value) {
        // TODO Auto-generated method stub
      }
    });
    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
      @Override
      public void onSelectionChange(final SelectionChangeEvent event) {
        translatorForm.setInfo(selectionModel.getSelectedObject());
      }
    });
    cellList.sinkEvents(com.google.gwt.user.client.Event.KEYEVENTS);
    // Create the UiBinder.
    final Binder uiBinder = GWT.create(Binder.class);
    initWidget(uiBinder.createAndBindUi(this));
    translatorForm.init(data, i18n, cellList);
    data.addDataDisplay(cellList);

    // Set the cellList as the display of the pagers.
    // pagerPanel is a scrollable pager that extends the range when the
    // user scrolls to the bottom. rangeLabelPager is a pager that displays the
    // current range, but does not have any controls to change the range.
    pagerPanel.setDisplay(cellList);
    // pagerPanel.setStyleName("k-i18n-trans-list");
    rangeLabelPager.setDisplay(cellList);
  }

  public void setLanguage(final I18nLanguageSimpleDTO language, final boolean toTranslate) {
    data.setLanguage(language, toTranslate);
    translatorForm.setToLanguage(language);
  }
}