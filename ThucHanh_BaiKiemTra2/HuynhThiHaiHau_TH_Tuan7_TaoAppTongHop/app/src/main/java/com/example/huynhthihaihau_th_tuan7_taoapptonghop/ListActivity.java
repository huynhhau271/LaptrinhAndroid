package com.example.huynhthihaihau_th_tuan7_taoapptonghop;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ListView lvMenu;
    ArrayList<Menu> arrayMenu;
    MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        AnhXa();
        adapter = new MenuAdapter(this, R.layout.dong_menu, arrayMenu);

        lvMenu.setAdapter(adapter);


    }

    private void XacNhanXoa(int position) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông báo!");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("Bạn có muốn xóa cây xanh này ra khỏi danh sách không?");
        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayMenu.remove(position);
                adapter.notifyDataSetChanged();

            }
        });
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }


    private void AnhXa() {
        lvMenu = (ListView) findViewById(R.id.ListviewMenu);
        arrayMenu = new ArrayList<>();
        arrayMenu.add(new Menu("Cây bàng", "Được trồng để che bóng mát","Lá màu xanh", R.drawable.caybang));
        arrayMenu.add(new Menu("Cây hoa sữa", "Tác dụng phát hãn, chỉ thống, thông kinh, bình suyễn","Lá màu xanh", R.drawable.cayhoasua));
        arrayMenu.add(new Menu("Cây phượng", "Hoa phượng nở báo hiệu mùa hè về","Lá màu xanh", R.drawable.cayphuong));
        arrayMenu.add(new Menu("Cây hoa hồng", "Trang trí cảnh quan trong gia đình thêm nhiều màu sác","Lá màu xanh", R.drawable.cayhoahong));
        arrayMenu.add(new Menu("Cây hoa cúc", "Trang trí cảnh quan trong gia đình vào những dịp lễ Tết","Lá màu xanh", R.drawable.cayhoacuc));

        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Menu fr = arrayMenu.get(i);
                doOpenMainActivity(fr.getTen(),fr.getMoTa(),fr.getHinh());
            }
        });
    }


    public void doOpenMainActivity(String ten, String mota, int hinh)
    {
        Intent myIntent;
        myIntent = new Intent( this, Detail.class);
        myIntent.putExtra("title",ten);
        myIntent.putExtra("des",mota);
        myIntent.putExtra("image",hinh);
        startActivity(myIntent);
    }


}