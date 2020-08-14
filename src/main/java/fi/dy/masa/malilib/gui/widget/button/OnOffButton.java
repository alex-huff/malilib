package fi.dy.masa.malilib.gui.widget.button;

import fi.dy.masa.malilib.render.message.MessageHelpers;
import fi.dy.masa.malilib.util.StringUtils;

public class OnOffButton extends GenericButton
{
    protected final String translationKey;

    /**
     * Pass -1 as the <b>width</b> to automatically set the width
     * to a value where the ON and OFF buttons are the same width,
     * using the given translation key.
     * @param x
     * @param y
     * @param width
     * @param rightAlign
     * @param translationKey
     * @param isCurrentlyOn
     * @param hoverStrings
     */
    public OnOffButton(int x, int y, int width, boolean rightAlign, String translationKey, boolean isCurrentlyOn, String... hoverStrings)
    {
        super(x, y, width, 20, "", hoverStrings);

        this.translationKey = translationKey;
        this.updateDisplayString(isCurrentlyOn);

        if (width < 0)
        {
            int w1 = this.getStringWidth(OnOffButton.getDisplayStringForStatus(translationKey, true));
            int w2 = this.getStringWidth(OnOffButton.getDisplayStringForStatus(translationKey, false));
            this.setWidth(Math.max(w1, w2) + 10);
        }

        this.setRightAlign(rightAlign, x, true);
    }

    public void updateDisplayString(boolean isCurrentlyOn)
    {
        this.displayString = getDisplayStringForStatus(this.translationKey, isCurrentlyOn);
    }

    public static String getDisplayStringForStatus(String translationKey, boolean isCurrentlyOn)
    {
        return StringUtils.translate(translationKey, MessageHelpers.getOnOffColored(isCurrentlyOn, true));
    }
}
