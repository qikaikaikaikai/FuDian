package com.example.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.greendao.db.Useinfo;
import com.example.greendao.db.UseinfoDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.add).setOnClickListener(this);
    }
    //增加
    public void add() {
        //年龄每次加1
        Useinfo useinfo = new Useinfo("小明", 18);
        UseinfoDao useinfoDao = application.getApplication().getDaoSession().getUseinfoDao();
        useinfoDao.insert(useinfo);
        Log.i("-------", "添加成功");
    }
//删除

    public void delet() {
        UseinfoDao useinfoDao = application.getApplication().getDaoSession().getUseinfoDao();
        List<Useinfo> list = useinfoDao.queryBuilder().list();
        if (list == null || list.isEmpty()) {
            return;
        }

        for (int j = 0; j < list.size(); j++) {

            Useinfo useinfo = list.get(j);
            if ("小明".equals(useinfo.getName())) {
                useinfoDao.delete(useinfo);
                Log.i("-------", "删除方法正在删除名字是张三的人");
            }
        }
        Log.i("-------", "删除成功");
    }

    //更改
    public void update() {
        UseinfoDao useinfoDao = application.getApplication().getDaoSession().getUseinfoDao();
        QueryBuilder<Useinfo> useinfoQueryBuilder = useinfoDao.queryBuilder();
        List<Useinfo> list = useinfoQueryBuilder.where(UseinfoDao.Properties.Age.eq(1)).list();
        if (list==null || list.isEmpty())
        {
            return;
        }
for (int i=0;i<list.size();i++)
{


    Useinfo useinfo = list.get(i);
    useinfo.setAge(18);
    useinfo.setName("小红");
    application.getApplication().getDaoSession().update(useinfo);
    Log.d("++++++++++++++","修改成功");
}
        List<Useinfo> li= application.getApplication().getDaoSession().getUseinfoDao().queryBuilder().list();

        if (li == null || li.isEmpty()) {
            Log.i("-------", "修改方法的暂无数据");
            return;
        }
        for (int j = 0; j < li.size(); j++) {
            Useinfo useinfo = li.get(j);
            Log.i("-------修改方法的遍历", "name:[" + useinfo.getName() + "],[age:" + useinfo.getAge() + "]");
        }

    }
//查找

    public void select() {
        UseinfoDao useinfoDao = application.getApplication().getDaoSession().getUseinfoDao();
        QueryBuilder<Useinfo> builder = useinfoDao.queryBuilder();
        List<Useinfo> list = builder.list();
        if (list == null || list.isEmpty()) {
            Log.i("-------", "所有数据为空");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Useinfo user = list.get(i);
            String name = user.getName();
            int age = user.getAge();
            Log.i("-------", "allName :  [name:" + name + "],[age:" + age + "]");
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case  R.id.add :
                add();
                break;
            case  R.id.select :
select();
                break;
            case  R.id.update :
update();
                break;
            case  R.id.delet :
delet();
                break;


        }
    }
}
