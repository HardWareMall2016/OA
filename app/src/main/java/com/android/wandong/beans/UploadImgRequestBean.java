package com.android.wandong.beans;

import java.util.List;

/**
 * 作者：伍岳 on 2016/8/18 22:39
 * 邮箱：wuyue8512@163.com
 * //
 * //         .............................................
 * //                  美女坐镇                  BUG辟易
 * //         .............................................
 * //
 * //                       .::::.
 * //                     .::::::::.
 * //                    :::::::::::
 * //                 ..:::::::::::'
 * //              '::::::::::::'
 * //                .::::::::::
 * //           '::::::::::::::..
 * //                ..::::::::::::.
 * //              ``::::::::::::::::
 * //               ::::``:::::::::'        .:::.
 * //              ::::'   ':::::'       .::::::::.
 * //            .::::'      ::::     .:::::::'::::.
 * //           .:::'       :::::  .:::::::::' ':::::.
 * //          .::'        :::::.:::::::::'      ':::::.
 * //         .::'         ::::::::::::::'         ``::::.
 * //     ...:::           ::::::::::::'              ``::.
 * //    ```` ':.          ':::::::::'                  ::::..
 * //                       '.:::::'                    ':'````..
 * //
 */
public class UploadImgRequestBean {
    private String PhotosId;
    private List<String> Photos;

    public String getPhotosId() {
        return PhotosId;
    }

    public void setPhotosId(String PhotosId) {
        this.PhotosId = PhotosId;
    }

    public List<String> getPhotos() {
        return Photos;
    }

    public void setPhotos(List<String> Photos) {
        this.Photos = Photos;
    }
}
