package com.marmar.nutricev.tabla;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class TableMainLayout extends RelativeLayout // implements TextWatcher
{

	public final String TAG = "TableMainLayout.java";

	int colorPurple = (Color.parseColor("#b1a0c7"));
	int colorGreen = (Color.parseColor("#c4d79b"));
	int colorBlue = (Color.parseColor("#95b2d7"));
	int colorRed = (Color.parseColor("#da9694"));

	String headers[] = { "Grupo Alimentos", "Equivalentes", "----------",
			"---HO---", "----------", "---PS---", "----------", "---LP---",
			"----------", "--Kcal--" };

	String leftheaders[] = { "Leche Descremada", "Leche Semi descremada",
			"Leche Entera", "Leche con Azucar", "Frutas", "Verduras",
			"Azucares sin grasa", "Azucares con grasa", "Leguminosas",
			"Formula1", "225.57	", "Cereales y Tuberculos sin grasa",
			"Cereales y Tuberculos con grasa", "Formula2", "61.52",
			"AOA muy poca grasa", "AOA poca grasa", "AOA moderada grasa",
			"AOA alto aporte de grasa", "Formula3", "54.63",
			"Aceite y Grasas con proteinas", "Aceite y Grasas sin proteinas",
			"Suma Total" };

	TableLayout tableA;
	TableLayout tableB;
	TableLayout tableC;
	TableLayout tableD;

	HorizontalScrollView horizontalScrollViewB;
	HorizontalScrollView horizontalScrollViewD;

	ScrollView scrollViewC;
	ScrollView scrollViewD;

	Context context;

	List<SampleObject> sampleObjects = this.sampleObjects();

	int headerCellsWidth[] = new int[headers.length];

	public TableMainLayout(Context context, Activity a) {
		super(context);

		this.context = context;

		// initialize the main components (TableLayouts, HorizontalScrollView,
		// ScrollView)
		this.initComponents();
		this.setComponentsId();
		this.setScrollViewAndHorizontalScrollViewTag();

		// no need to assemble component A, since it is just a table
		this.horizontalScrollViewB.addView(this.tableB);

		this.scrollViewC.addView(this.tableC);

		this.scrollViewD.addView(this.horizontalScrollViewD);
		this.horizontalScrollViewD.addView(this.tableD);

		// add the components to be part of the main layout
		this.addComponentToMainLayout();
		this.setBackgroundColor(Color.GRAY);

		// add some table rows
		this.addTableRowToTableA();
		this.addTableRowToTableB();

		this.resizeHeaderHeight();

		this.getTableRowHeaderCellWidth();

		this.generateTableC_AndTable_D();

		this.resizeBodyTableRowHeight();

		// TableRow tr = (TableRow) tableD.getChildAt(tableD.getChildCount());
		// tr.setBackgroundColor(colorBlue);

	}

	// this is just the sample data
	List<SampleObject> sampleObjects() {

		List<SampleObject> sampleObjects = new ArrayList<SampleObject>();

		for (int x = 0; x < leftheaders.length; x++) {

			SampleObject sampleObject = new SampleObject(leftheaders[x], "0",
					"0", "0", "0", "0", "0", "0", "0", "0");

			sampleObjects.add(sampleObject);
		}

		return sampleObjects;

	}

	// initalized components
	private void initComponents() {

		this.tableA = new TableLayout(this.context);
		this.tableB = new TableLayout(this.context);
		this.tableC = new TableLayout(this.context);
		this.tableD = new TableLayout(this.context);

		this.horizontalScrollViewB = new MyHorizontalScrollView(this.context);
		this.horizontalScrollViewD = new MyHorizontalScrollView(this.context);

		this.scrollViewC = new MyScrollView(this.context);
		this.scrollViewD = new MyScrollView(this.context);

		this.tableA.setBackgroundColor(Color.GREEN);
		this.horizontalScrollViewB.setBackgroundColor(Color.LTGRAY);

	}

	// set essential component IDs
	private void setComponentsId() {
		this.tableA.setId(1);
		this.horizontalScrollViewB.setId(2);
		this.scrollViewC.setId(3);
		this.scrollViewD.setId(4);
	}

	// set tags for some horizontal and vertical scroll view
	private void setScrollViewAndHorizontalScrollViewTag() {

		this.horizontalScrollViewB.setTag("horizontal scroll view b");
		this.horizontalScrollViewD.setTag("horizontal scroll view d");

		this.scrollViewC.setTag("scroll view c");
		this.scrollViewD.setTag("scroll view d");
	}

	// we add the components here in our TableMainLayout
	private void addComponentToMainLayout() {

		// RelativeLayout params were very useful here
		// the addRule method is the key to arrange the components properly
		RelativeLayout.LayoutParams componentB_Params = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		componentB_Params.addRule(RelativeLayout.RIGHT_OF, this.tableA.getId());

		RelativeLayout.LayoutParams componentC_Params = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		componentC_Params.addRule(RelativeLayout.BELOW, this.tableA.getId());

		RelativeLayout.LayoutParams componentD_Params = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		componentD_Params.addRule(RelativeLayout.RIGHT_OF,
				this.scrollViewC.getId());
		componentD_Params.addRule(RelativeLayout.BELOW,
				this.horizontalScrollViewB.getId());

		// 'this' is a relative layout,
		// we extend this table layout as relative layout as seen during the
		// creation of this class
		this.addView(this.tableA);
		this.addView(this.horizontalScrollViewB, componentB_Params);
		this.addView(this.scrollViewC, componentC_Params);
		this.addView(this.scrollViewD, componentD_Params);

	}

	private void addTableRowToTableA() {
		this.tableA.addView(this.componentATableRow());
	}

	private void addTableRowToTableB() {
		this.tableB.addView(this.componentBTableRow());
	}

	// generate table row of table A
	private TableRow componentATableRow() {

		TableRow componentATableRow = new TableRow(this.context);

		Button b = new Button(context);
		b.setText("Actualizar");
		b.setBackgroundColor(Color.YELLOW);
		componentATableRow.addView(b);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				calculateCells();
				// TODO
			}
		});

		return componentATableRow;
	}

	// generate table row of table B
	private TableRow componentBTableRow() {

		TableRow componentBTableRow = new TableRow(this.context);
		int headerFieldCount = this.headers.length;

		TableRow.LayoutParams params = new TableRow.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
		params.setMargins(2, 0, 0, 0);

		for (int x = 0; x < (headerFieldCount - 1); x++) {
			EditText EditText = this.headerEditText(this.headers[x + 1]);
			EditText.setLayoutParams(params);
			EditText.setBackgroundColor(colorRed);
			componentBTableRow.addView(EditText);
		}

		return componentBTableRow;
	}

	// generate table row of table C and table D
	private void generateTableC_AndTable_D() {

		// just seeing some header cell width
		for (int x = 0; x < this.headerCellsWidth.length; x++) {
			Log.v("TableMainLayout.java", this.headerCellsWidth[x] + "");
		}

		int i = 0;
		for (SampleObject sampleObject : this.sampleObjects) {

			TableRow tableRowForTableC = this
					.tableRowForTableC(sampleObject, i);
			TableRow tableRowForTableD = this
					.tableRowForTableD(sampleObject, i);

			tableRowForTableC.setBackgroundColor(Color.LTGRAY);
			tableRowForTableD.setBackgroundColor(Color.LTGRAY);

			this.tableC.addView(tableRowForTableC);
			this.tableD.addView(tableRowForTableD);

			i++;
		}
	}

	// TODO
	// a TableRow for table C
	private TableRow tableRowForTableC(SampleObject sampleObject, int row) {

		TableRow.LayoutParams params = new TableRow.LayoutParams(
				this.headerCellsWidth[0], LayoutParams.MATCH_PARENT);
		params.setMargins(0, 2, 0, 0);

		TableRow tableRowForTableC = new TableRow(this.context);
		EditText editText = this.bodyEditText2(sampleObject.header1);
		editText.setBackgroundColor(colorPurple);

		if (row == 10 || row == 14 || row == 20) {
			editText.setInputType(InputType.TYPE_CLASS_NUMBER
					| InputType.TYPE_NUMBER_FLAG_DECIMAL
					| InputType.TYPE_NUMBER_FLAG_SIGNED);
		}else{
			editText.setKeyListener(null);
		}
		// TODO
		tableRowForTableC.addView(editText, params);

		return tableRowForTableC;
	}

	// TODO
	private TableRow tableRowForTableD(SampleObject sampleObject, int row) {

		TableRow taleRowForTableD = new TableRow(this.context);

		int loopCount = ((TableRow) this.tableB.getChildAt(0)).getChildCount();
		String info[] = { sampleObject.header2, sampleObject.header3,
				sampleObject.header4, sampleObject.header5,
				sampleObject.header6, sampleObject.header7,
				sampleObject.header8, sampleObject.header9,
				sampleObject.header10 };

		for (int x = 0; x < loopCount; x++) {
			TableRow.LayoutParams params = new TableRow.LayoutParams(
					headerCellsWidth[x + 1], LayoutParams.MATCH_PARENT);
			params.setMargins(2, 2, 0, 0);

			EditText editTextB = this.bodyEditText(info[x]);
			// editTextB.setId(id[row][x + 1]);
			// editTextB.sette
			// ets[row][x] = editTextB;

			if (x == 2 || x == 4 || x == 6 || x == 8) {
				editTextB.setBackgroundColor(colorGreen);
				editTextB.setKeyListener(null);
			}
			if (row == 10 || row == 14 || row == 20) {
				editTextB.setBackgroundColor(colorPurple);
			}
			if (row == 23) {
				editTextB.setBackgroundColor(colorBlue);
			}
			taleRowForTableD.addView(editTextB, params);
		}

		return taleRowForTableD;

	}

	// TODO
	// table cell standard EditText
	private EditText bodyEditText(String label) {

		EditText bodyEditText = new EditText(this.context);
		bodyEditText.setBackgroundColor(Color.WHITE);
		bodyEditText.setText(label);
		bodyEditText.setGravity(Gravity.CENTER);
		bodyEditText.setPadding(5, 5, 5, 5);
		// bodyEditText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
		bodyEditText.setInputType(InputType.TYPE_CLASS_NUMBER
				| InputType.TYPE_NUMBER_FLAG_DECIMAL
				| InputType.TYPE_NUMBER_FLAG_SIGNED);
		// bodyEditText.addTextChangedListener(this);

		return bodyEditText;
	}

	private EditText bodyEditText2(String label) {

		EditText bodyEditText = new EditText(this.context);
		bodyEditText.setBackgroundColor(Color.WHITE);
		bodyEditText.setText(label);
		bodyEditText.setGravity(Gravity.CENTER);
		bodyEditText.setPadding(5, 5, 5, 5);
		// bodyEditText.setKeyListener(null);
		// bodyEditText.setInputType(InputType.TYPE_CLASS_NUMBER
		// | InputType.TYPE_NUMBER_FLAG_DECIMAL
		// | InputType.TYPE_NUMBER_FLAG_SIGNED);
		// bodyEditText.addTextChangedListener(this);

		return bodyEditText;
	}

	// header standard EditText
	EditText headerEditText(String label) {

		EditText headerEditText = new EditText(this.context);
		headerEditText.setBackgroundColor(Color.WHITE);
		headerEditText.setText(label);
		headerEditText.setGravity(Gravity.CENTER);
		headerEditText.setPadding(5, 5, 5, 5);
		headerEditText.setKeyListener(null);

		return headerEditText;
	}

	// resizing TableRow height starts here
	void resizeHeaderHeight() {

		TableRow productNameHeaderTableRow = (TableRow) this.tableA
				.getChildAt(0);
		TableRow productInfoTableRow = (TableRow) this.tableB.getChildAt(0);

		int rowAHeight = this.viewHeight(productNameHeaderTableRow);
		int rowBHeight = this.viewHeight(productInfoTableRow);

		TableRow tableRow = rowAHeight < rowBHeight ? productNameHeaderTableRow
				: productInfoTableRow;
		int finalHeight = rowAHeight > rowBHeight ? rowAHeight : rowBHeight;

		this.matchLayoutHeight(tableRow, finalHeight);
	}

	void getTableRowHeaderCellWidth() {

		int tableAChildCount = ((TableRow) this.tableA.getChildAt(0))
				.getChildCount();
		int tableBChildCount = ((TableRow) this.tableB.getChildAt(0))
				.getChildCount();
		;

		for (int x = 0; x < (tableAChildCount + tableBChildCount); x++) {

			if (x == 0) {
				this.headerCellsWidth[x] = this
						.viewWidth(((TableRow) this.tableA.getChildAt(0))
								.getChildAt(x));
			} else {
				this.headerCellsWidth[x] = this
						.viewWidth(((TableRow) this.tableB.getChildAt(0))
								.getChildAt(x - 1));
			}

		}
	}

	// resize body table row height
	void resizeBodyTableRowHeight() {

		int tableC_ChildCount = this.tableC.getChildCount();

		for (int x = 0; x < tableC_ChildCount; x++) {

			TableRow productNameHeaderTableRow = (TableRow) this.tableC
					.getChildAt(x);
			TableRow productInfoTableRow = (TableRow) this.tableD.getChildAt(x);

			int rowAHeight = this.viewHeight(productNameHeaderTableRow);
			int rowBHeight = this.viewHeight(productInfoTableRow);

			TableRow tableRow = rowAHeight < rowBHeight ? productNameHeaderTableRow
					: productInfoTableRow;
			int finalHeight = rowAHeight > rowBHeight ? rowAHeight : rowBHeight;

			this.matchLayoutHeight(tableRow, finalHeight);
		}

	}

	// match all height in a table row
	// to make a standard TableRow height
	private void matchLayoutHeight(TableRow tableRow, int height) {

		int tableRowChildCount = tableRow.getChildCount();

		// if a TableRow has only 1 child
		if (tableRow.getChildCount() == 1) {

			View view = tableRow.getChildAt(0);
			TableRow.LayoutParams params = (TableRow.LayoutParams) view
					.getLayoutParams();
			params.height = height - (params.bottomMargin + params.topMargin);

			return;
		}

		// if a TableRow has more than 1 child
		for (int x = 0; x < tableRowChildCount; x++) {

			View view = tableRow.getChildAt(x);

			TableRow.LayoutParams params = (TableRow.LayoutParams) view
					.getLayoutParams();

			if (!isTheHeighestLayout(tableRow, x)) {
				params.height = height
						- (params.bottomMargin + params.topMargin);
				return;
			}
		}

	}

	// check if the view has the highest height in a TableRow
	private boolean isTheHeighestLayout(TableRow tableRow, int layoutPosition) {

		int tableRowChildCount = tableRow.getChildCount();
		int heighestViewPosition = -1;
		int viewHeight = 0;

		for (int x = 0; x < tableRowChildCount; x++) {
			View view = tableRow.getChildAt(x);
			int height = this.viewHeight(view);

			if (viewHeight < height) {
				heighestViewPosition = x;
				viewHeight = height;
			}
		}

		return heighestViewPosition == layoutPosition;
	}

	// read a view's height
	private int viewHeight(View view) {
		view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
		return view.getMeasuredHeight();
	}

	// read a view's width
	private int viewWidth(View view) {
		view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
		return view.getMeasuredWidth();
	}

	// horizontal scroll view custom class
	class MyHorizontalScrollView extends HorizontalScrollView {

		public MyHorizontalScrollView(Context context) {
			super(context);
		}

		@Override
		protected void onScrollChanged(int l, int t, int oldl, int oldt) {
			String tag = (String) this.getTag();

			if (tag.equalsIgnoreCase("horizontal scroll view b")) {
				horizontalScrollViewD.scrollTo(l, 0);
			} else {
				horizontalScrollViewB.scrollTo(l, 0);
			}
		}

	}

	// scroll view custom class
	class MyScrollView extends ScrollView {

		public MyScrollView(Context context) {
			super(context);
		}

		@Override
		protected void onScrollChanged(int l, int t, int oldl, int oldt) {

			String tag = (String) this.getTag();

			if (tag.equalsIgnoreCase("scroll view c")) {
				scrollViewD.scrollTo(0, t);
			} else {
				scrollViewC.scrollTo(0, t);
			}
		}
	}

	float col[] = new float[10];
	float ho, ps, lp, kcal;

	int rows;
	int tr_cols;
	TableRow tr;
	EditText et;
	boolean regular;

	private void calculateCells() {
		ho = 0;
		ps = 0;
		lp = 0;
		kcal = 0;
		rows = tableD.getChildCount();

		for (int r = 0; r < rows; r++) {
			tr = (TableRow) tableD.getChildAt(r);

			tr_cols = tr.getChildCount();
			for (int j = 0; j < tr_cols; j++) {
				et = (EditText) tr.getChildAt(j);
				col[j] = getValue(et);
			}
			regular = true;
			if (r == 10) {
				col[0] = ho;
				col[2] = (225.57f - ho) / col[1];
				col[3] = col[4] = col[5] = col[6] = col[7] = col[8] = 0;
				regular = false;
			}

			if (r == 14) {
				col[0] = ps;
				col[2] = (61.27f - ps) / col[1];
				col[3] = col[4] = col[5] = col[6] = col[7] = col[8] = 0;
				regular = false;
			}
			if (r == 20) {
				col[0] = lp;
				col[2] = (54.63f - lp) / col[1];
				col[3] = col[4] = col[5] = col[6] = col[7] = col[8] = 0;
				regular = false;
			}

			if (regular) {
				col[2] = col[0] * col[1];
				col[4] = col[0] * col[3];
				col[6] = col[0] * col[5];
				col[8] = col[0] * col[7];

				ho += col[2];
				ps += col[4];
				lp += col[6];
				kcal += col[8];
			}

			if (r == 9 || r == 13 || r == 19) {
				col[0] = col[1] = col[2] = col[3] = col[4] = col[5] = col[6] = col[7] = col[8] = 0;
			}

			for (int j = 0; j < tr_cols; j++) {
				et = (EditText) tr.getChildAt(j);
				et.setText(col[j] + "");
			}
			if (r == 9) {
				et = (EditText) tr.getChildAt(2);
				et.setText(ho + "");
			}

			if (r == 13) {
				et = (EditText) tr.getChildAt(4);
				et.setText(ps + "");
			}

			if (r == 19) {
				et = (EditText) tr.getChildAt(6);
				et.setText(lp + "");
			}

			if (r == 23) {
				et = (EditText) tr.getChildAt(2);
				et.setText(ho + "");

				et = (EditText) tr.getChildAt(4);
				et.setText(ps + "");

				et = (EditText) tr.getChildAt(6);
				et.setText(lp + "");

				et = (EditText) tr.getChildAt(8);
				et.setText(kcal + "");
			}
		}

	}

	private float getValue(EditText et) {
		if (et == null) {
			System.err.println("et is null!");
			return 0;
		}
		Editable t = et.getText();
		if (t == null) {
			System.err.println("text is null!");
			return 0;
		}
		String s = t.toString();
		float v = 0;
		try {
			v = Float.parseFloat(s);
		} catch (Exception e) {
			System.err.println("error parsing float");
			return 0;
		}
		return v;
	}
}