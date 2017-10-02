package com.easyloan.utils;

import com.easyloan.dto.Msg;
import com.easyloan.enums.UserStateEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class FileUploadUtils {

    public static final String PERSONAL_DATUM_PATH = "/Users/kenliang/loan_pic/personal_loan_img/";

    public static final String HEAD_IMG_PATH = "/Users/kenliang/loan_pic/header_img/";

    public static final String ID_NUMBER_IMG_PATH = "/Users/kenliang/loan_pic/personal_certification_img/";

    public static final String BORROW_DATUM_PATH = "/Users/kenliang/loan_pic/borrow_img/";

    public static final String COMPANY_MORTGAGE_PATH = "/Users/kenliang/loan_pic/company_mortgage_img/";

    public static final String COMPANY_CORRELATION_PATH = "/Users/kenliang/loan_pic/company_correlation_img/";

    public static String fileUpload(MultipartFile[] files, String path) {
        String imgs_name = "";
        for (int i = 0; i < files.length; i++) {
            String fileName = files[i].getOriginalFilename();
            //如果上传图片含有中文
            if(RegxDictionary.validateRegx(fileName,RegxDictionary.REGEX_CHINESE)) {
                //生成4位随机数
                fileName = String.valueOf((Math.random()*(9999-1000+1))+1000);//产生1000-9999的随机数
            }
            File dest = new File(path + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                files[i].transferTo(dest);
                imgs_name += dest.getName() + ",";
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return imgs_name.substring(0, imgs_name.length() - 1);
    }

}
