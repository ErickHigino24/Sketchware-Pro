package com.besome.sketch.editor.manage;

import a.a.a.Gt;
import a.a.a.Ht;
import a.a.a.It;
import a.a.a.Jt;
import a.a.a.Kt;
import a.a.a.Lt;
import a.a.a.eC;
import a.a.a.jC;
import a.a.a.rq;
import a.a.a.wq;
import a.a.a.xB;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.besome.sketch.beans.ProjectFileBean;
import com.besome.sketch.beans.ViewBean;
import com.besome.sketch.lib.base.BaseAppCompatActivity;
import com.besome.sketch.lib.ui.SelectableButtonBar;
import com.google.android.gms.analytics.HitBuilders;
import java.util.ArrayList;
import java.util.Iterator;

public class ViewSelectorActivity extends BaseAppCompatActivity {

    public LinearLayout container;

    public RecyclerView list_xml;

    public Adapter adapter;

    public String sc_id;

    public ProjectFileBean projectFile;

    public SelectableButtonBar button_bar;

    public TextView empty_message;

    public ImageView add_button;

    public String currentXml;
    public int v;
    public final int k = 0;
    public final int l = 1;

    public boolean isCustomView = false;
    public int[] x = new int[19];

    public static ArrayList a(ViewSelectorActivity viewSelectorActivity) {
        return viewSelectorActivity.l();
    }

    public final int f(int i) {
        String replace = String.format("%4s", Integer.toBinaryString(i)).replace(' ', '0');
        return getApplicationContext().getResources().getIdentifier("activity_" + replace, "drawable", getApplicationContext().getPackageName());
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(2130771982, 2130771983); // R.anim.ani_fade_in, R.anim.ani_fade_out
    }

    public final ArrayList<String> l() {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<ProjectFileBean> b = jC.b(this.sc_id).b();
        if (b != null) {
            Iterator<ProjectFileBean> it = b.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().fileName);
            }
        }
        ArrayList<ProjectFileBean> c = jC.b(this.sc_id).c();
        if (c != null) {
            Iterator<ProjectFileBean> it2 = c.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().fileName);
            }
        }
        return arrayList;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 264:
                if (resultCode == -1) {
                    ProjectFileBean projectFileBean = (ProjectFileBean) data.getParcelableExtra("project_file");
                    jC.b(this.sc_id).a(projectFileBean);
                    if (projectFileBean.hasActivityOption(4)) {
                        jC.b(this.sc_id).a(2, projectFileBean.getDrawerName());
                    }
                    if (data.hasExtra("preset_views")) {
                        a(projectFileBean, data.getParcelableArrayListExtra("preset_views"));
                    }
                    jC.b(this.sc_id).j();
                    jC.b(this.sc_id).l();
                    this.adapter.notifyDataSetChanged();
                    return;
                }
                return;
            case 265:
                if (resultCode == -1) {
                    ProjectFileBean projectFileBean2 = (ProjectFileBean) data.getParcelableExtra("project_file");
                    ProjectFileBean projectFileBean3 = jC.b(this.sc_id).b().get(this.adapter.selectedItem);
                    projectFileBean3.keyboardSetting = projectFileBean2.keyboardSetting;
                    projectFileBean3.orientation = projectFileBean2.orientation;
                    projectFileBean3.options = projectFileBean2.options;
                    if (projectFileBean2.hasActivityOption(4)) {
                        jC.b(this.sc_id).a(2, projectFileBean2.getDrawerName());
                    } else {
                        jC.b(this.sc_id).b(2, projectFileBean2.getDrawerName());
                    }
                    if (projectFileBean2.hasActivityOption(4) || projectFileBean2.hasActivityOption(8)) {
                        jC.c(this.sc_id).c().useYn = "Y";
                    }
                    Adapter adapter = this.adapter;
                    adapter.notifyItemChanged(adapter.selectedItem);
                    Intent intent = new Intent();
                    intent.putExtra("project_file", projectFileBean2);
                    setResult(-1, intent);
                    return;
                }
                return;
            case 266:
                if (resultCode == -1) {
                    ProjectFileBean projectFileBean4 = (ProjectFileBean) data.getParcelableExtra("project_file");
                    jC.b(this.sc_id).a(projectFileBean4);
                    if (data.hasExtra("preset_views")) {
                        a(projectFileBean4, data.getParcelableArrayListExtra("preset_views"));
                    }
                    jC.b(this.sc_id).j();
                    jC.b(this.sc_id).l();
                    this.adapter.notifyDataSetChanged();
                    return;
                }
                return;
            default:
                switch (requestCode) {
                    case 276:
                        if (resultCode == -1) {
                            ProjectFileBean projectFileBean5 = (ProjectFileBean) data.getParcelableExtra("preset_data");
                            ProjectFileBean projectFileBean6 = jC.b(this.sc_id).b().get(this.adapter.selectedItem);
                            projectFileBean6.keyboardSetting = projectFileBean5.keyboardSetting;
                            projectFileBean6.orientation = projectFileBean5.orientation;
                            projectFileBean6.options = projectFileBean5.options;
                            if (projectFileBean5.hasActivityOption(4) || projectFileBean5.hasActivityOption(8)) {
                                jC.c(this.sc_id).c().useYn = "Y";
                            }
                            a(projectFileBean5, projectFileBean6, requestCode);
                            jC.b(this.sc_id).j();
                            this.adapter.notifyDataSetChanged();
                            Intent intent2 = new Intent();
                            intent2.putExtra("project_file", projectFileBean6);
                            setResult(-1, intent2);
                            return;
                        }
                        return;
                    case 277:
                    case 278:
                        if (resultCode == -1) {
                            ProjectFileBean projectFileBean7 = (ProjectFileBean) data.getParcelableExtra("preset_data");
                            ProjectFileBean projectFileBean8 = jC.b(this.sc_id).c().get(this.adapter.selectedItem);
                            a(projectFileBean7, projectFileBean8, requestCode);
                            jC.b(this.sc_id).j();
                            this.adapter.notifyDataSetChanged();
                            Intent intent3 = new Intent();
                            intent3.putExtra("project_file", projectFileBean8);
                            setResult(-1, intent3);
                            return;
                        }
                        return;
                    default:
                        return;
                }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2131427419); // R.layout.file_selector_popup_select_xml
        Intent intent = getIntent();
        if (savedInstanceState == null) {
            this.sc_id = intent.getStringExtra("sc_id");
            this.currentXml = intent.getStringExtra("current_xml");
            this.isCustomView = intent.getBooleanExtra("is_custom_view", false);
        } else {
            this.sc_id = savedInstanceState.getString("sc_id");
            this.currentXml = savedInstanceState.getString("current_xml");
            this.isCustomView = savedInstanceState.getBoolean("is_custom_view");
        }
        if (this.isCustomView) {
            this.v = 1;
        } else {
            this.v = 0;
        }
        this.button_bar = (SelectableButtonBar) findViewById(2131230867);
        this.empty_message = (TextView) findViewById(2131231017);
        this.list_xml = (RecyclerView) findViewById(2131231471);
        this.add_button = (ImageView) findViewById(2131230755);
        this.container = (LinearLayout) findViewById(2131230931);
        this.button_bar.a(0, xB.b().a(this, 2131625046).toUpperCase()); // R.string.common_word_view
        this.button_bar.a(1, xB.b().a(this, 2131624984).toUpperCase()); // R.string.common_word_custom_view
        this.button_bar.setSelectedItemByIndex(this.v);
        this.button_bar.a();
        this.adapter = new Adapter();
        this.list_xml.setLayoutManager(new LinearLayoutManager(getApplicationContext(), 1, false));
        this.list_xml.setHasFixedSize(true);
        this.list_xml.setAdapter(this.adapter);
        this.button_bar.setListener(new Gt(this));
        this.empty_message.setText(xB.b().a(this, 2131625294)); // R.string.design_manager_view_message_no_view
        this.add_button.setOnClickListener(new Ht(this));
        this.container.setOnClickListener(new It(this));
        overridePendingTransition(2130771982, 2130771983); // R.anim.ani_fade_in, R.anim.ani_fade_out
    }

    @Override
    public void onResume() {
        super.onResume();
        this.d.setScreenName(ViewSelectorActivity.class.getSimpleName().toString());
        this.d.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("sc_id", this.sc_id);
        outState.putString("current_xml", this.currentXml);
        outState.putBoolean("is_custom_view", this.isCustomView);
        super.onSaveInstanceState(outState);
    }

    class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

        public int selectedItem = -1;

        class ViewHolder extends RecyclerView.ViewHolder {

            public LinearLayout container;

            public ImageView img_edit;

            public ImageView img_view;

            public TextView tv_filename;

            public TextView tv_linked_filename;

            public ImageView img_preset_setting;

            public ViewHolder(View itemView) {
                super(itemView);
                this.container = (LinearLayout) itemView.findViewById(2131230931);
                this.img_edit = (ImageView) itemView.findViewById(2131231138);
                this.img_view = (ImageView) itemView.findViewById(2131231204);
                this.tv_filename = (TextView) itemView.findViewById(2131231979);
                this.tv_linked_filename = (TextView) itemView.findViewById(2131232032);
                this.img_preset_setting = (ImageView) itemView.findViewById(2131231168);
                itemView.setOnClickListener(new Jt(this, Adapter.this));
                this.img_view.setOnClickListener(new Kt(this, Adapter.this));
                this.img_preset_setting.setOnClickListener(new Lt(this, Adapter.this));
            }
        }

        public Adapter() {
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int position) {
            viewHolder.container.setBackgroundColor(ViewSelectorActivity.this.getResources().getColor(2131034318));
            int i = ViewSelectorActivity.this.v;
            if (i == 0) {
                viewHolder.tv_filename.setVisibility(0);
                viewHolder.tv_linked_filename.setVisibility(0);
                ProjectFileBean projectFileBean = jC.b(ViewSelectorActivity.this.sc_id).b().get(position);
                String xmlName = projectFileBean.getXmlName();
                if (ViewSelectorActivity.this.currentXml.equals(xmlName)) {
                    viewHolder.container.setBackgroundColor(ViewSelectorActivity.this.getResources().getColor(2131034285));
                }
                String javaName = projectFileBean.getJavaName();
                viewHolder.img_edit.setVisibility(0);
                viewHolder.img_view.setImageResource(ViewSelectorActivity.this.f(projectFileBean.options));
                viewHolder.tv_filename.setText(xmlName);
                viewHolder.tv_linked_filename.setVisibility(0);
                viewHolder.tv_linked_filename.setText(javaName);
                viewHolder.tv_filename.setTextColor(-12566464);
                return;
            }
            if (i == 1) {
                viewHolder.img_edit.setVisibility(8);
                viewHolder.tv_linked_filename.setVisibility(8);
                ProjectFileBean projectFileBean2 = jC.b(ViewSelectorActivity.this.sc_id).c().get(position);
                if (ViewSelectorActivity.this.currentXml.equals(projectFileBean2.getXmlName())) {
                    viewHolder.container.setBackgroundColor(ViewSelectorActivity.this.getResources().getColor(2131034285));
                }
                if (projectFileBean2.fileType == 2) {
                    viewHolder.img_view.setImageResource(ViewSelectorActivity.this.f(4));
                    viewHolder.tv_filename.setText(projectFileBean2.fileName.substring(1));
                    viewHolder.tv_filename.setTextColor(-65536);
                } else {
                    viewHolder.img_view.setImageResource(ViewSelectorActivity.this.f(3));
                    viewHolder.tv_filename.setText(projectFileBean2.getXmlName());
                    viewHolder.tv_filename.setTextColor(-16777216);
                }
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(2131427420, parent, false));
        }

        @Override
        public int getItemCount() {
            int size;
            ViewSelectorActivity.this.empty_message.setVisibility(8);
            ViewSelectorActivity viewSelectorActivity = ViewSelectorActivity.this;
            int i = viewSelectorActivity.v;
            if (i == 0) {
                size = jC.b(viewSelectorActivity.sc_id).b().size();
            } else {
                size = i == 1 ? jC.b(viewSelectorActivity.sc_id).c().size() : 0;
            }
            if (size == 0) {
                ViewSelectorActivity.this.empty_message.setVisibility(0);
            }
            return size;
        }
    }

    public final void a(ProjectFileBean projectFileBean, ArrayList<ViewBean> arrayList) {
        jC.a(this.sc_id);
        Iterator<ViewBean> it = eC.a(arrayList).iterator();
        while (it.hasNext()) {
            ViewBean next = it.next();
            next.id = a(next.type, projectFileBean.getXmlName());
            jC.a(this.sc_id).a(projectFileBean.getXmlName(), next);
            if (next.type == 3 && projectFileBean.fileType == 0) {
                jC.a(this.sc_id).a(projectFileBean.getJavaName(), 1, next.type, next.id, "onClick");
            }
        }
    }

    public final void a(ProjectFileBean projectFileBean, ProjectFileBean projectFileBean2, int i) {
        ArrayList<ViewBean> d = jC.a(this.sc_id).d(projectFileBean2.getXmlName());
        for (int size = d.size() - 1; size >= 0; size--) {
            jC.a(this.sc_id).a(projectFileBean2, d.get(size));
        }
        ArrayList<ViewBean> a = a(projectFileBean.presetName, i);
        jC.a(this.sc_id);
        Iterator<ViewBean> it = eC.a(a).iterator();
        while (it.hasNext()) {
            ViewBean next = it.next();
            next.id = a(next.type, projectFileBean2.getXmlName());
            jC.a(this.sc_id).a(projectFileBean2.getXmlName(), next);
            if (next.type == 3 && projectFileBean2.fileType == 0) {
                jC.a(this.sc_id).a(projectFileBean2.getJavaName(), 1, next.type, next.id, "onClick");
            }
        }
    }

    public final ArrayList<ViewBean> a(String str, int i) {
        ArrayList<ViewBean> arrayList = new ArrayList<>();
        switch (i) {
            case 276:
                return rq.f(str);
            case 277:
                return rq.b(str);
            case 278:
                return rq.d(str);
            default:
                return arrayList;
        }
    }

    public final String a(int i, String str) {
        String b = wq.b(i);
        StringBuilder sb = new StringBuilder();
        sb.append(b);
        int[] iArr = this.x;
        int i2 = iArr[i] + 1;
        iArr[i] = i2;
        sb.append(i2);
        String sb2 = sb.toString();
        ArrayList<ViewBean> d = jC.a(this.sc_id).d(str);
        while (true) {
            boolean z = false;
            Iterator<ViewBean> it = d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (sb2.equals(it.next().id)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return sb2;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(b);
            int[] iArr2 = this.x;
            int i3 = iArr2[i] + 1;
            iArr2[i] = i3;
            sb3.append(i3);
            sb2 = sb3.toString();
        }
    }

    public final int a(ProjectFileBean projectFileBean) {
        if (this.v == 0) {
            return 276;
        }
        return projectFileBean.fileType == 1 ? 277 : 278;
    }
}
