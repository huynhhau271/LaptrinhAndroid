package com.example.bt_recycleview;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter {
    //Dữ liệu hiện thị là danh sách sinh viên
    private List mStutents;
    // Lưu Context để dễ dàng truy cập
    private Context mContext;

    public StudentAdapter(List _student, Context mContext) {
        this.mStutents = _student;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Nạp layout cho View biểu diễn phần tử sinh viên
        View studentView =
                inflater.inflate(R.layout.student_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(studentView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student = mStutents.get(position);

        holder.studentname.setText(student.getmName());
        holder.birthyear.setText(student.getBirthYear()+"");


    }

    @Override
    public int getItemCount() {
        return mStutents.size();
    }

    /**
     * Lớp nắm giữ cấu trúc view
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private View itemview;
        public TextView studentname;
        public TextView birthyear;
        public Button detail_button;

        public ViewHolder(View itemView) {
            super(itemView);
            itemview = itemView;
            studentname = itemView.findViewById(R.id.studentname);
            birthyear = itemView.findViewById(R.id.birthyear);
            detail_button = itemView.findViewById(R.id.detail_button);

            //Xử lý khi nút Chi tiết được bấm
            detail_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                                    studentname.getText() +" | "
                                            + " Demo function", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}