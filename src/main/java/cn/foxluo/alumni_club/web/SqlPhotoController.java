package cn.foxluo.alumni_club.web;
import cn.foxluo.alumni_club.core.Result;
import cn.foxluo.alumni_club.core.ResultGenerator;
import cn.foxluo.alumni_club.model.SqlPhoto;
import cn.foxluo.alumni_club.service.SqlPhotoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
* Created by foxluo.cn on 2020/12/21.
*/
@RestController
@RequestMapping("/sql/photo")
public class SqlPhotoController {
    @Resource
    private SqlPhotoService sqlPhotoService;

    @PostMapping("/add")
    public Result add(@RequestParam("file") MultipartFile file,String name) {
        SqlPhoto sqlPhoto=new SqlPhoto();
        String path = "C:\\upload\\sql_photos\\";
        if (name.contains(",layui-layer-iframe2"))
            name.replace(",layui-layer-iframe2","");
        //文件命名
        String originalFilename = file.getOriginalFilename();

        //获取文件的后缀名
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());

        //判断文件是否是图片
        String[] imagType = {".jpg", ".png", ".bmp", ".gif"};
        List<String> imageTyepLists = Arrays.asList(imagType);
        if (imageTyepLists.contains(extendName)) {
            String filename=UUID.randomUUID().toString()+"."+extendName;
            File dir = new File(path,filename);
            File filepath = new File(path);
            //创建存放图片的文件夹
            if (!filepath.exists()) {
                filepath.mkdirs();
            }
            //把图片放进文件夹中
            try {
                file.transferTo(dir);
                sqlPhoto.setUrl("http://www.foxluo.cn/alumni_club-1.0/img/"+filename);
                sqlPhoto.setName(name);
                sqlPhoto.setTime(new Date());
                sqlPhotoService.save(sqlPhoto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        SqlPhoto sqlPhoto=sqlPhotoService.findById(id);
        if (!StringUtils.isEmpty(sqlPhoto.getUrl())) {
            try {
                if (sqlPhoto.getUrl().contains("http://www.foxluo.cn/alumni_club-1.0/img/")){
                    sqlPhoto.setUrl(sqlPhoto.getUrl().replace("http://www.foxluo.cn/alumni_club-1.0/img/","C:/upload/sql_photos/"));
                    File file=new File(sqlPhoto.getUrl());
                    if (file.exists()){
                        file.delete();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        sqlPhotoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(SqlPhoto sqlPhoto,long timeStep) {
        sqlPhoto.setTime(new Date(timeStep));
        sqlPhotoService.update(sqlPhoto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SqlPhoto sqlPhoto = sqlPhotoService.findById(id);
        return ResultGenerator.genSuccessResult(sqlPhoto);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SqlPhoto> list = sqlPhotoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
