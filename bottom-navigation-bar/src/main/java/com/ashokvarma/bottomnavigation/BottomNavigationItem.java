package com.ashokvarma.bottomnavigation;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;

/**
 * Class description : Holds data for tabs (i.e data structure which holds all data to paint a tab)
 *
 * @author ashokvarma
 * @version 1.0
 * @since 19 Mar 2016
 */
public class BottomNavigationItem {

    protected int mIconResource;
    protected Drawable mIcon;
    protected int mTitleResource;
    protected String mTitle;
    protected int mActiveColorResource;
    protected String mActiveColorCode;
    protected int mInActiveColorResource;
    protected String mInActiveColorCode;

    /**
     * @param mIconResource resource for the Tab icon.
     * @param mTitle        title for the Tab.
     */
    public BottomNavigationItem(@DrawableRes int mIconResource, @NonNull String mTitle) {
        this.mIconResource = mIconResource;
        this.mTitle = mTitle;
    }

    /**
     * @param mIcon  drawable icon for the Tab.
     * @param mTitle title for the Tab.
     */
    public BottomNavigationItem(Drawable mIcon, @NonNull String mTitle) {
        this.mIcon = mIcon;
        this.mTitle = mTitle;
    }

    /**
     * @param mIcon          drawable icon for the Tab.
     * @param mTitleResource resource for the title.
     */
    public BottomNavigationItem(Drawable mIcon, @StringRes int mTitleResource) {
        this.mIcon = mIcon;
        this.mTitleResource = mTitleResource;
    }

    /**
     * @param mIconResource  resource for the Tab icon.
     * @param mTitleResource resource for the title.
     */
    public BottomNavigationItem(@DrawableRes int mIconResource, @StringRes int mTitleResource) {
        this.mIconResource = mIconResource;
        this.mTitleResource = mTitleResource;
    }

    /**
     * @param colorResource resource for active color
     * @return this, to allow builder pattern
     */
    public BottomNavigationItem setActiveColor(@ColorRes int colorResource) {
        this.mActiveColorResource = colorResource;
        return this;
    }

    /**
     * @param colorCode color code for active color
     * @return this, to allow builder pattern
     */
    public BottomNavigationItem setActiveColor(String colorCode) {
        this.mActiveColorCode = colorCode;
        return this;
    }

    /**
     * @param colorResource resource for in-active color
     * @return this, to allow builder pattern
     */
    public BottomNavigationItem setInActiveColor(@ColorRes int colorResource) {
        this.mInActiveColorResource = colorResource;
        return this;
    }

    /**
     * @param colorCode color code for in-active color
     * @return this, to allow builder pattern
     */
    public BottomNavigationItem setInActiveColor(String colorCode) {
        this.mInActiveColorCode = colorCode;
        return this;
    }

    /**
     * @param context to fetch drawable
     * @return icon drawable
     */
    protected Drawable getIcon(Context context) {
        if (this.mIconResource != 0) {
            return ContextCompat.getDrawable(context, this.mIconResource);
        } else {
            return this.mIcon;
        }
    }

    /**
     * @param context to fetch resource
     * @return title string
     */
    protected String getTitle(Context context) {
        if (this.mTitleResource != 0) {
            return context.getString(this.mTitleResource);
        } else {
            return this.mTitle;
        }
    }

    /**
     * @param context to fetch color
     * @return active color (or) -1 if no color is specified
     */
    protected int getActiveColor(Context context) {
        if (this.mActiveColorResource != 0) {
            return context.getResources().getColor(mActiveColorResource);
        } else if (this.mActiveColorCode != null && !TextUtils.isEmpty(mActiveColorCode)) {
            return Color.parseColor(mActiveColorCode);
        } else {
            return -1;
        }
    }

    /**
     * @param context to fetch color
     * @return in-active color (or) -1 if no color is specified
     */
    protected int getInActiveColor(Context context) {
        if (this.mInActiveColorResource != 0) {
            return context.getResources().getColor(mInActiveColorResource);
        } else if (this.mInActiveColorCode != null && !TextUtils.isEmpty(mInActiveColorCode)) {
            return Color.parseColor(mInActiveColorCode);
        } else {
            return -1;
        }
    }

}
